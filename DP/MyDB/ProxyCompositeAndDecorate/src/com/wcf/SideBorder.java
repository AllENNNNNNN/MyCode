package com.wcf;

public class SideBorder extends Border{

	private char borderChar;
	SideBorder(Printable printer,char ch) {
		super(printer);
		this.borderChar=ch;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.printer.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.printer.setName(name);
	}

	@Override
	public void setContext(String context) {
		// TODO Auto-generated method stub
		this.printer.setContext(context);
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return this.printer.getRows();
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 2+this.printer.getColumns();
	}

	@Override
	public String getRowText(int index) {
		// TODO Auto-generated method stub
		return this.borderChar+this.printer.getRowText(index)+this.borderChar;
	}

	public char getBorderChar() {
		return borderChar;
	}

	public void setBorderChar(char borderChar) {
		this.borderChar = borderChar;
	}

}
