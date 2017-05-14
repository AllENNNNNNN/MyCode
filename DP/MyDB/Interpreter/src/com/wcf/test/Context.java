package com.wcf.test;

public class Context {
	private String statement;
	private int data;
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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
