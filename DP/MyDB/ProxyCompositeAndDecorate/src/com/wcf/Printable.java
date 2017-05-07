package com.wcf;

public abstract class Printable {
	public abstract String getName();
	public abstract void setName(String name);
	public abstract void setContext(String context);
	public boolean add(Printable printable){return false;}
	public boolean remove(Printable printable){return false;}
	public  abstract int getRows();
	public abstract  int getColumns();
	public abstract String getRowText(int index);
	public void print()
	{
		//System.out.println(this.getRows());
		for(int i=0;i<this.getRows();i++)
			System.out.println(this.getRowText(i));
	}
	public  Printable getPrint()
	{
		return null;
	}
}
