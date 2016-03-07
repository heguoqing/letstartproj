package com.springapp.persist.Dialect;

public class MySQL5Dialect implements Dialect
{
	public String getPaginationSql(String sql, int offset, int limit)
	{
		return sql + " limit " + offset + "," + limit;
	}
}
