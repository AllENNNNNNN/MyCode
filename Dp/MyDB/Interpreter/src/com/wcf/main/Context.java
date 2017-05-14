package com.wcf.main;

public class Context {
	private String statement;
	private long data;
	public Context(String statement)
	{
		this.statement=statement;
		data=0;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

}
