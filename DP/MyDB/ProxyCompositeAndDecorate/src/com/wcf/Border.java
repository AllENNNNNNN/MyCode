package com.wcf;

public abstract class Border extends Printable{

	
	protected Printable printer;
	Border(Printable printer)
	{
		this.printer=printer;
	}
}
