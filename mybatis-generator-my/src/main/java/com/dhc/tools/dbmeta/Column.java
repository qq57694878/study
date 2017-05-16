package com.dhc.tools.dbmeta;


import com.dhc.tools.java.FullyQualifiedJavaType;

/**
 * com.dhc.framework.test2
 * Column.java
 * @version 2008-4-29
 */
public class Column
{
	private String tableName;

	private String name;

	private String comment;

	private String type;

	protected int jdbcType;

	protected String jdbcTypeName;

	protected boolean nullable;

	protected int length;

	protected int scale;


	protected FullyQualifiedJavaType fullyQualifiedJavaType;

	public FullyQualifiedJavaType getFullyQualifiedJavaType() {
		return fullyQualifiedJavaType;
	}

	public void setFullyQualifiedJavaType(FullyQualifiedJavaType fullyQualifiedJavaType) {
		this.fullyQualifiedJavaType = fullyQualifiedJavaType;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(int jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJdbcTypeName() {
		return jdbcTypeName;
	}

	public void setJdbcTypeName(String jdbcTypeName) {
		this.jdbcTypeName = jdbcTypeName;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "Column{" +
				"tableName='" + tableName + '\'' +
				", name='" + name + '\'' +
				", comment='" + comment + '\'' +
				", type='" + type + '\'' +
				", jdbcType=" + jdbcType +
				", jdbcTypeName='" + jdbcTypeName + '\'' +
				", nullable=" + nullable +
				", length=" + length +
				", scale=" + scale +
				", fullyQualifiedJavaType=" + fullyQualifiedJavaType +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Column column = (Column) o;

		if (tableName != null ? !tableName.equals(column.tableName) : column.tableName != null) return false;
		return name != null ? name.equals(column.name) : column.name == null;
	}

	@Override
	public int hashCode() {
		int result = tableName != null ? tableName.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}

