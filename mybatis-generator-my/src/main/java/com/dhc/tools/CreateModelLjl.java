package com.dhc.tools;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @version 2008-4-29
 */
public class CreateModelLjl {
    public CreateModelLjl() {
    /*	ResourceBundle bundle =	ResourceBundle.getBundle("createModel");
		driverClassName = bundle.getString("driverClassName");
		dbURL = bundle.getString("url");
		dbUser = bundle.getString("username");
		dbPass=bundle.getString("password");
		pack = bundle.getString("package");
		sourcePackage = bundle.getString("sourcePackage");
		String tableStr = bundle.getString("tables");*/
        InputStream inStream = CreateModelLjl.class.getResourceAsStream(confFile);
        Properties prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        driverClassName = prop.getProperty("driverClassName");
        dbURL = prop.getProperty("url");
        dbUser = prop.getProperty("username");
        dbPass = prop.getProperty("password");
        pack = prop.getProperty("package");
        sourcePackage = prop.getProperty("sourcePackage");
        String tableStr = prop.getProperty("tables");
        List<String> list = new ArrayList<String>();
        for (String tableName : tableStr.split(",")) {
            if (tableName != null && tableName.trim().length() > 0) {
                list.add(tableName);
            }
        }
        tNames = list.toArray(new String[]{});
    }

    private final String confFile = "createModel.properties";

    private String driverClassName;

    private String pack;

    private String[] tNames;

    private String dbURL;

    private String dbUser = "giis";

    private String dbPass = "orcl";

    private String sourcePackage = "src";

    public static void main(String[] args) throws Exception {

        CreateModelLjl create = new CreateModelLjl();
        create.createModel();
    }

    public void createModel() throws Exception {

        String modelPack = pack;
        List tableList = getTableNames(Arrays.asList(tNames));
        for (int i = 0; i < tableList.size(); i++) {
            getTable((Table) tableList.get(i), modelPack);
        }
    }


    public List getTableNames(List tNames) throws Exception {
        Connection con = connectToOracleDb();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append("select TABLE_NAME,COMMENTS from all_tab_comments where table_type = 'TABLE'");
        sqlBuf.append(" and (1=2 ");
        for (int i = 0; i < tNames.size(); i++) {
            sqlBuf.append(" or TABLE_NAME like '" + ((String) tNames.get(i)).toUpperCase() + "' ");
        }
        sqlBuf.append(")");
        System.out.println("---" + sqlBuf.toString());
        pstmt = con.prepareStatement(sqlBuf.toString());
        rs = pstmt.executeQuery();
        ArrayList list = new ArrayList();
        while (rs.next()) {
            Table table = new Table();
            table.setName(rs.getString(1));
            table.setComment(rs.getString(2));
            list.add(table);
        }
        return list;
    }

    public void getTable(Table table, String pack) throws Exception {
        Connection con = connectToOracleDb();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer strBuf = new StringBuffer();

        strBuf.append(" select distinct(t2.COLUMN_NAME),t1.COMMENTS,t2.DATA_TYPE from all_col_comments t1,user_tab_columns t2 where t1.COLUMN_NAME = t2.COLUMN_NAME(+) and t1.table_name='" + table.getName() + "' and t2.table_name = '" + table.getName() + "'");
        System.out.println(strBuf.toString());
        pstmt = con.prepareStatement(strBuf.toString());
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Column column = new Column();
            column.setName(rs.getString(1));
            column.setComment(rs.getString(2));
            column.setType(rs.getString(3));
            table.addColumn(column);

        }
        printModel(table, pack);
    }

    public void printModel_bak(Table table, String pack) {
        List colList = table.getColumns();
        Map<String, String> columnTypeMap = new HashMap<String, String>();
        Set<String> importSet = new HashSet<String>();
        for (int i = 0; i < colList.size(); i++) {
            Column c = (Column) colList.get(i);
            String type = c.getType();
            String javaType = "java.lang.String";
            if (type.equals("VARCHAR2") || type.equals("CHAR") || type.equals("NVARCHAR2") || type.equals("NCHAR") || type.equals("CLOB") || type.equals("BLOB")) {
                javaType = "String";
            } else if (type.equals("NUMBER") || type.equals("LONG") || type.equals("FLOAT") || type.equals("BINARY_DOUBLE") || type.equals("BINARY_FLOAT")) {
                javaType = "long";
            } else if (type.equals("DATE") || type.startsWith("TIMESTAMP")) {
                javaType = "java.util.Date";
                importSet.add(javaType);
            } else if (type.equals("char")) {
                javaType = "char";
            }
            columnTypeMap.put(c.getName(), javaType);
        }

        StringBuffer strBuf = new StringBuffer();
        strBuf.append("package " + pack + ";\n");
        strBuf.append("\n");
        strBuf.append("import com.dhc.framework.base.model.BaseModel;\n");
        for (String s : importSet) {
            strBuf.append("import " + s + ";\n");
        }
        strBuf.append("\n");

        if (table.getComment() != null) {
            strBuf.append("	/**\n");
            strBuf.append("	 *" + table.getComment() + "\n");
            strBuf.append("	 */\n");
        } else {

        }

        strBuf.append("\n");
        //strBuf.append("public class " + (table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model") + " implements BaseModel\n");
        strBuf.append("public class " + (table.getName().toUpperCase() + "Model") + " implements BaseModel\n");
        strBuf.append("{\n");

        for (int i = 0; i < colList.size(); i++) {
            Column column = (Column) colList.get(i);

            if (column.getComment() != null) {
                strBuf.append("	/**\n");
                strBuf.append("	 *" + column.getComment() + "\n");
                strBuf.append("	 */\n");
            } else {

            }
            String truncType = columnTypeMap.get(column.getName());
            if (truncType.indexOf('.') > 0) {
                truncType = truncType.substring(truncType.lastIndexOf('.') + 1);
            }
            strBuf.append("	private " + truncType + " " + (column.getName()).toLowerCase() + ";\n");
            strBuf.append("\n");
        }
        strBuf.append("\n");
        for (int i = 0; i < colList.size(); i++) {
            Column column = (Column) colList.get(i);
            String colName = column.getName();
            String truncType = columnTypeMap.get(column.getName());
            if (truncType.indexOf('.') > 0) {
                truncType = truncType.substring(truncType.lastIndexOf('.') + 1);
            }
            strBuf.append("\n");
            strBuf.append("	public void set" + colName.substring(0, 1).toUpperCase() + colName.substring(1).toLowerCase() + "(" + truncType + " " + colName.toLowerCase() + ")\n");
            strBuf.append("	{\n");
            strBuf.append("		this." + colName.toLowerCase() + " = " + colName.toLowerCase() + ";\n");
            strBuf.append("	}\n");
            strBuf.append("\n");
            strBuf.append("	public " + truncType + " get" + colName.substring(0, 1).toUpperCase() + colName.substring(1).toLowerCase() + "()\n");
            strBuf.append("	{\n");
            strBuf.append("		return " + colName.toLowerCase() + ";\n");
            strBuf.append("	}\n");
            strBuf.append("\n");
        }
        strBuf.append("}\n");

        String path = System.getProperty("user.dir");
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        String fileFoldName = path + sourcePackage + "/" + pack.replace('.', '/') + "/" + table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model.java";
        saveToFile(strBuf.toString(), fileFoldName);
    }


    public void printModel(Table table, String pack) {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("package " + pack + ";\n");
        strBuf.append("\n");
        strBuf.append("import com.dhc.framework.base.model.BaseModel;\n");
        strBuf.append("\n");

        if (table.getComment() != null) {
            strBuf.append("	/**\n");
            strBuf.append("	 *" + table.getComment() + "\n");
            strBuf.append("	 */\n");
        } else {

        }

        strBuf.append("\n");
        strBuf.append("public class " + (table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model") + " implements BaseModel\n");
        strBuf.append("{\n");
        List colList = table.getColumns();
        for (int i = 0; i < colList.size(); i++) {
            Column column = (Column) colList.get(i);

            if (column.getComment() != null) {
                strBuf.append("	/**\n");
                strBuf.append("	 *" + column.getComment() + "\n");
                strBuf.append("	 */\n");
            } else {

            }

            strBuf.append("	private String " + (column.getName()).toLowerCase() + ";\n");
            strBuf.append("\n");
        }
        strBuf.append("\n");
        for (int i = 0; i < colList.size(); i++) {
            Column column = (Column) colList.get(i);
            String colName = column.getName();
            strBuf.append("\n");
            strBuf.append("	public void set" + colName.substring(0, 1).toUpperCase() + colName.substring(1).toLowerCase() + "(String " + colName.toLowerCase() + ")\n");
            strBuf.append("	{\n");
            strBuf.append("		this." + colName.toLowerCase() + " = " + colName.toLowerCase() + ";\n");
            strBuf.append("	}\n");
            strBuf.append("\n");
            strBuf.append("	public String get" + colName.substring(0, 1).toUpperCase() + colName.substring(1).toLowerCase() + "()\n");
            strBuf.append("	{\n");
            strBuf.append("		return " + colName.toLowerCase() + ";\n");
            strBuf.append("	}\n");
            strBuf.append("\n");
        }
        strBuf.append("}\n");

        String path = System.getProperty("user.dir");
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        String fileFoldName = path + sourcePackage + "/" + pack.replace('.', '/') + "/" + table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model.java";
        saveToFile(strBuf.toString(), fileFoldName);
    }

    public void printModel_(Table table, String pack) {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("package " + pack + ";\n");
        strBuf.append("\n");
        strBuf.append("import com.dhc.framework.base.model.BaseModel;\n");
        strBuf.append("\n");

        if (table.getComment() != null) {
            strBuf.append("	/**\n");
            strBuf.append("	 *" + table.getComment() + "\n");
            strBuf.append("	 */\n");
        } else {

        }

        strBuf.append("\n");
        strBuf.append("public class " + (table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model") + " implements BaseModel\n");
        strBuf.append("{\n");
        List colList = table.getColumns();
        for (int i = 0; i < colList.size(); i++) {
            Column column = (Column) colList.get(i);

            if (column.getComment() != null) {
                strBuf.append("	/**\n");
                strBuf.append("	 *" + column.getComment() + "\n");
                strBuf.append("	 */\n");
            } else {

            }

            strBuf.append("	private String " + (column.getName()).toLowerCase() + ";\n");
            strBuf.append("\n");
        }
        strBuf.append("\n");
        for (int i = 0; i < colList.size(); i++) {
            Column column = (Column) colList.get(i);
            String colName = column.getName();
            strBuf.append("\n");
            strBuf.append("	public void set" + colName.substring(0, 1).toUpperCase() + colName.substring(1).toLowerCase() + "(String " + colName.toLowerCase() + ")\n");
            strBuf.append("	{\n");
            strBuf.append("		this." + colName.toLowerCase() + " = " + colName.toLowerCase() + ";\n");
            strBuf.append("	}\n");
            strBuf.append("\n");
            strBuf.append("	public String get" + colName.substring(0, 1).toUpperCase() + colName.substring(1).toLowerCase() + "()\n");
            strBuf.append("	{\n");
            strBuf.append("		return " + colName.toLowerCase() + ";\n");
            strBuf.append("	}\n");
            strBuf.append("\n");
        }
        strBuf.append("}\n");

        String path = System.getProperty("user.dir");
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        String fileFoldName = path + sourcePackage + "/" + pack.replace('.', '/') + "/" + table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model.java";
        saveToFile(strBuf.toString(), fileFoldName);
    }

    public void saveToFile(String fileContent, String fileName) {

        try {
            FileWriter fw = new FileWriter(new File(fileName));
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(fileName);
    }

    public Connection connectToOracleDb() throws Exception {
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        return conn;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String[] getTNames() {
        return tNames;
    }

    public void setTNames(String[] names) {
        tNames = names;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getSourcePackage() {
        return sourcePackage;
    }

    public void setSourcePackage(String sourcePackage) {
        this.sourcePackage = sourcePackage;
    }
}
