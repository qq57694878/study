package com.dhc.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @version 2008-4-29
 * 
 */
public class CreateModel
{
	public static String pack = "com.dhc.tools.models";

	public static String tName = "ADF01";

	public static String dbURL = "jdbc:oracle:thin:@136.24.18.122:1521:orcl";

	public static String dbUser = "db_yw";

	public static String dbPass = "yw2011";

	public static void main(String[] args) throws Exception
	{

		String modelPack = pack;
		List tNames = new ArrayList();
		tNames.add(tName);

		List tableList = getTableNames(tNames);
		for (int i = 0; i < tableList.size(); i++)
		{
			getTable((Table) tableList.get(i), modelPack);
		}
	}

	public static List getTableNames(List tNames) throws Exception
	{
		Connection con = connectToOracleDb();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("select TABLE_NAME,COMMENTS from all_tab_comments where table_type = 'TABLE'");
		sqlBuf.append(" and (1=2 ");
		for (int i = 0; i < tNames.size(); i++)
		{
			sqlBuf.append(" or TABLE_NAME like '" + ((String) tNames.get(i)).toUpperCase() + "' ");
		}
		sqlBuf.append(")");
		System.out.println("---" + sqlBuf.toString());
		pstmt = con.prepareStatement(sqlBuf.toString());
		rs = pstmt.executeQuery();
		ArrayList list = new ArrayList();
		while (rs.next())
		{
			Table table = new Table();
			table.setName(rs.getString(1));
			table.setComment(rs.getString(2));
			list.add(table);
		}
		return list;
	}

	public static void getTable(Table table, String pack) throws Exception
	{
		Connection con = connectToOracleDb();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer strBuf = new StringBuffer();

		strBuf.append(" select COLUMN_NAME,COMMENTS from all_col_comments where table_name = '" + table.getName() + "'");
		System.out.println(strBuf.toString());
		pstmt = con.prepareStatement(strBuf.toString());
		rs = pstmt.executeQuery();

		while (rs.next())
		{
			Column column = new Column();
			column.setName(rs.getString(1));
			column.setComment(rs.getString(2));
			table.addColumn(column);

		}
		printModel(table, pack);
	}

	public static void printModel(Table table, String pack)
	{
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("package " + pack + ";\n");
		strBuf.append("\n");
		strBuf.append("import com.dhc.framework.base.model.BaseModel;\n");
		strBuf.append("\n");

		if (table.getComment() != null)
		{
			strBuf.append("	/**\n");
			strBuf.append("	 *" + table.getComment() + "\n");
			strBuf.append("	 */\n");
		}
		else
		{

		}

		strBuf.append("\n");
		strBuf.append("public class " + (table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model") + " implements BaseModel\n");
		strBuf.append("{\n");
		List colList = table.getColumns();
		for (int i = 0; i < colList.size(); i++)
		{
			Column column = (Column) colList.get(i);

			if (column.getComment() != null)
			{
				strBuf.append("	/**\n");
				strBuf.append("	 *" + column.getComment() + "\n");
				strBuf.append("	 */\n");
			}
			else
			{

			}

			strBuf.append("	private String " + (column.getName()).toLowerCase() + ";\n");
			strBuf.append("\n");
		}
		strBuf.append("\n");
		for (int i = 0; i < colList.size(); i++)
		{
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

		String fileFoldName = "model_tools/" + pack.replace('.', '/') + "/" + table.getName().substring(0, 1).toUpperCase() + table.getName().substring(1).toLowerCase() + "Model.java";
		saveToFile(strBuf.toString(), fileFoldName);
	}

	public static void saveToFile(String fileContent, String fileName)
	{

		try
		{
			FileWriter fw = new FileWriter(new File(fileName));
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(fileContent);
			bw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(fileName);
	}

	public static Connection connectToOracleDb() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		return conn;
	}
}
