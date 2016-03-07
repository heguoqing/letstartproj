package com.springapp.persist.Dialect;

public interface Dialect
{
	enum Type
	{
		MYSQL
		{
			public String getValue()
			{
				return "mysql";
			}
		},
		SQLSERVER
		{
			public String getValue()
			{
				return "sqlserver";
			}
		},
		ORACLE
		{
			public String getValue()
			{
				return "oracle";
			}
		};
		public abstract String getValue();
	}

	String getPaginationSql(String sql, int offset, int limit);
}
