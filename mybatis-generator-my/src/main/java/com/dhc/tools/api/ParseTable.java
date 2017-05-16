package com.dhc.tools.api;

import com.dhc.tools.dbmeta.Column;
import com.dhc.tools.dbmeta.Table;
import com.dhc.tools.config.Config;
import com.dhc.tools.java.JavaTypeResolver;
import com.dhc.tools.java.JavaTypeResolverDefaultImpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/3.
 */
public class ParseTable {

    private Config config;

    /** The java type resolver. */
    private JavaTypeResolver javaTypeResolver;

    public ParseTable(Config config) {
        this.config = config;
        javaTypeResolver = new JavaTypeResolverDefaultImpl();
    }
    public List<Table> parseTableMeta()throws Exception{
        List<Table> result = null;
        if(config.gettNames() != null){
             result = new ArrayList<Table>(config.gettNames().length);
             for(String tableName:config.gettNames()){
                 result.add(getTableMeta(tableName));
             }
        }
        return result;
    }

    public Table getTableMeta(String tableName) throws Exception{
        Table table =null;
        Connection connection = getConnection();
        DatabaseMetaData databaseMetaData =  connection.getMetaData();
        ResultSet rs = databaseMetaData.getTables(null,null,tableName,new String[]{"TABLE"});
        while(rs.next()){
            table = new Table();
            table.setComment(rs.getString("REMARKS"));
            table.setName(rs.getString("TABLE_NAME"));
            //找到一个表就终止
            break;
        }
        //q未找到退出
        if(table==null){return null;}
        //设置列属性
        rs = databaseMetaData.getColumns(null,null,table.getName(),null);
        while(rs.next()){
            Column column = new Column();
            column.setComment(rs.getString("REMARKS"));
            column.setName(rs.getString("COLUMN_NAME"));
            column.setTableName(rs.getString("TABLE_NAME"));
            column.setJdbcType(rs.getInt("DATA_TYPE")); //$NON-NLS-1$
            column.setLength(rs.getInt("COLUMN_SIZE")); //$NON-NLS-1$
            column.setScale(rs.getInt("DECIMAL_DIGITS"));
            column.setJdbcTypeName(javaTypeResolver.calculateJdbcTypeName(column));
            column.setFullyQualifiedJavaType(javaTypeResolver.calculateJavaType(column));
            table.addColumn(column);
        }
        rs = databaseMetaData.getPrimaryKeys(null,null,table.getName());
        Map<String,Column> map = new HashMap<String,Column>();
        for(int i=0;i<table.getColumns().size();i++){
            map.put(table.getColumns().get(i).getName(),table.getColumns().get(i));
        }
        while(rs.next()){
            String COLUMN_NAME = rs.getString("COLUMN_NAME");
            table.addPrimaryKey(map.get(COLUMN_NAME));
        }
        closeConnection(connection);
        return table;
    }
    /**
     * Gets the connection.
     *
     * @return the connection
     * @throws SQLException
     *             the SQL exception
     */
    private Connection getConnection() throws Exception {
        JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory(config);
        return connectionFactory.getConnection();
    }
    /**
     * Close connection.
     *
     * @param connection
     *            the connection
     */
    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // ignore
            }
        }
    }

}
