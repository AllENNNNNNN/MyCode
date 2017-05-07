package com.wcf;

public class Printer extends Printable{

	private String name;
	private String context;

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getRowText(int index) {
		// TODO Auto-generated method stub
		return this.context;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return this.context.getBytes().length;
	}
	

}
