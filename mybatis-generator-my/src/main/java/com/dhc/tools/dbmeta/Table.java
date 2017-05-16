package com.dhc.tools.dbmeta;

import java.util.ArrayList;
import java.util.List;


/**
 * com.dhc.framework.test2.service
 * Table.java
 * @version 2008-4-29
 */
public class Table
{
	private List<Column> primaryKeys = new ArrayList<Column>();

	private String name;

	private String comment;

	private List<Column> columns = new ArrayList<Column>();
	
	public List<Column> getColumns(){
		return columns;
	}
	
	public void addColumn(Column column){
		columns.add(column);
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void addPrimaryKey(Column column){
		this.primaryKeys.add(column);
	}

	public List<Column> getPrimaryKeys() {
		return primaryKeys;
	}

	@Override
	public String toString() {
		return "Table{" +
				"primaryKeys=" + primaryKeys +
				", name='" + name + '\'' +
				", comment='" + comment + '\'' +
				", columns=" + columns +
				'}';
	}
}

