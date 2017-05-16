package com.dhc.tools;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 * com.dhc.framework.test2
 * CreateModel.java
 * @version 2008-4-29

 */
public class CreateModelDBLink
{
	public static String pack = "com.dhc.framework.test2.models";
	public static String tName = "taba";
	public static String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static String dbUser = "giis";
	public static String dbPass = "orcl";

	public static void main(String[] args) throws Exception{

		String modelPack = pack;
		List tNames = new ArrayList();
		tNames.add(tName);

		List tableList = getTableNames(tNames);
		for(int i = 0; i < tableList.size(); i++){
			getTable((Table)tableList.get(i),modelPack);
			getTableView(((Table)tableList.get(i)).getName(),modelPack);
		}
	}

	public static void getTableView(String tName,String modelPack)throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append(" select owner,table_name,column_name,data_type,''||data_length data_length,nullable,''||column_id column_id, ");
		sql.append(" ( ");
		sql.append(" select ''||position from  ");
		sql.append(" ( ");
		sql.append(" select a.owner,a.table_name,b.COLUMN_NAME,b.position from  all_constraints a,all_cons_columns b  ");
		sql.append(" where a.constraint_name = b.constraint_name and a.owner = b.owner and a.constraint_type='P' ");
		sql.append(" ) b where a.table_name=b.table_name and a.owner = b.owner and a.column_name = b.column_name ");
		sql.append(" ) prim ");
		sql.append(" from all_tab_columns a where a.table_name = '" + tName + "' order by owner, table_name, 0+column_id  ");
		Connection   con   =connectToOracleDb();
	    PreparedStatement   pstmt   =   null;
	    ResultSet   rs   =   null;

	    pstmt = con.prepareStatement(sql.toString());
	    rs = pstmt.executeQuery();
	    StringBuffer strBuf = new StringBuffer();
	    strBuf.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n");
	    strBuf.append("<table>\n");
	    while(rs.next()){
	    	strBuf.append("\t<column>\n");
	    	strBuf.append("\t\t<table_name>"+rs.getString("table_name")+"</table_name>\n");
	    	strBuf.append("\t\t<column_name>"+rs.getString("column_name")+"</column_name>\n");
	    	strBuf.append("\t\t<data_type>"+rs.getString("data_type")+"</data_type>\n");
	    	strBuf.append("\t\t<data_length>"+rs.getString("data_length")+"</data_length>\n");
	    	strBuf.append("\t\t<nullable>"+rs.getString("nullable")+"</nullable>\n");
	    	strBuf.append("\t\t<column_id>"+rs.getString("column_id")+"</column_id>\n");
	    	strBuf.append("\t\t<prim>"+rs.getString("prim")+"</prim>\n");
	    	strBuf.append("\t</column>\n");
	    }
	    strBuf.append("</table>\n");
	    //System.out.println(strBuf);
		String fileFoldName = "test_src/"+pack.replace('.', '/')+"/"+tName.substring(0,1).toUpperCase()+tName.substring(1).toLowerCase()+".xml";
		saveToFile(strBuf.toString(),fileFoldName);
	}

	public static List getTableNames(List tNames) throws Exception{
		Connection   con   =connectToOracleDb();
	    PreparedStatement   pstmt   =   null;
	    ResultSet   rs   =   null;
	    StringBuffer sqlBuf = new StringBuffer();
	    sqlBuf.append("select TABLE_NAME,COMMENTS from user_tab_comments where table_type = 'TABLE'");
	    sqlBuf.append(" and (1=2 ");
	    for(int i = 0; i < tNames.size(); i++){
	    	sqlBuf.append(" or TABLE_NAME like '"+((String)tNames.get(i)).toUpperCase()+"' ");
	    }
	    sqlBuf.append(")");
	    System.out.println("---"+sqlBuf.toString());
	    pstmt = con.prepareStatement(sqlBuf.toString());
	    rs = pstmt.executeQuery();
		ArrayList list = new ArrayList();
	    while(rs.next()){
	    	Table table = new Table();
			table.setName(rs.getString(1));
			table.setComment(rs.getString(2));
			list.add(table);
	    }
	    return list;
	}

	public static void getTable(Table table,String pack) throws Exception{
		Connection   con   =connectToOracleDb();
	    PreparedStatement   pstmt   =   null;
	    ResultSet   rs   =   null;
	    StringBuffer strBuf = new StringBuffer();

	    strBuf.append(" select COLUMN_NAME,COMMENTS from all_col_comments where table_name = '"+table.getName()+"'");
	    System.out.println(strBuf.toString());
	    pstmt = con.prepareStatement(strBuf.toString());
	    rs = pstmt.executeQuery();

	    while(rs.next()){
	    	Column column = new Column();
	    	column.setName(rs.getString(1));
	    	column.setComment(rs.getString(2));
	    	table.addColumn(column);

	    }
	    printModel(table,pack);
	}

	public static void printModel(Table table,String pack){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("package "+pack+";\n");
		strBuf.append("\n");
		strBuf.append("import com.dhc.framework.base.model.BaseModel;\n");
		strBuf.append("\n");

		if(table.getComment() != null){
			strBuf.append("	/**\n");
			strBuf.append("	 *"+table.getComment()+"\n");
			strBuf.append("	 */\n");
		}else{

		}

		strBuf.append("\n");
		strBuf.append("public class "+(table.getName().substring(0,1).toUpperCase()+table.getName().substring(1).toLowerCase()+"Model")+" implements BaseModel\n");
		strBuf.append("{\n");
		List colList = table.getColumns();
		for(int i = 0; i < colList.size(); i++){
			Column column = (Column)colList.get(i);

			if(column.getComment() != null){
				strBuf.append("	/**\n");
				strBuf.append("	 *"+column.getComment()+"\n");
				strBuf.append("	 */\n");
			}else{

			}

			strBuf.append("	private String "+(column.getName()).toLowerCase()+";\n");
			strBuf.append("\n");
		}
		strBuf.append("\n");
		for(int i = 0; i < colList.size(); i++){
			Column column = (Column)colList.get(i);
			String colName = column.getName();
			strBuf.append("\n");
			strBuf.append("	public void set"+colName.substring(0,1).toUpperCase()+colName.substring(1).toLowerCase()+"(String "+colName.toLowerCase()+")\n");
			strBuf.append("	{\n");
			strBuf.append("		this."+colName.toLowerCase()+" = "+colName.toLowerCase()+";\n");
			strBuf.append("	}\n");
			strBuf.append("\n");
			strBuf.append("	public String get"+colName.substring(0,1).toUpperCase()+colName.substring(1).toLowerCase()+"()\n");
			strBuf.append("	{\n");
			strBuf.append("		return "+colName.toLowerCase()+";\n");
			strBuf.append("	}\n");
			strBuf.append("\n");
		}
		strBuf.append("}\n");

		String fileFoldName = "test_src/"+pack.replace('.', '/')+"/"+table.getName().substring(0,1).toUpperCase()+table.getName().substring(1).toLowerCase()+"Model.java";
		saveToFile(strBuf.toString(),fileFoldName);
	}

    public static void saveToFile(String fileContent,String fileName)
    {

		try{
			FileWriter fw = new FileWriter(new File(fileName));
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(fileContent);
			bw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(fileName);
	}

	public static Connection connectToOracleDb()throws Exception
	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn=DriverManager.getConnection(dbURL,dbUser,dbPass);
		    return conn;
	}
}

