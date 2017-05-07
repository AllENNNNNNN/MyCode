package com.wcf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcretePrinter extends Printable{

	private List<Printable> printerList=new ArrayList<Printable>();
	private String name;
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

	@Override
	public void setContext(String context) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.printerList.size();i++)
			this.printerList.get(i).setContext(context);
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		int Rows=0;
		for(int i=0;i<this.printerList.size();i++)
		{
			Rows+=this.printerList.get(i).getRows();
			//System.out.println("ConcretePrinter:"+i+this.printerList.get(i).getRows());
		}
		
		return Rows;
	}

	@Override
	public String getRowText(int index) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.printerList.size();i++)
		{
			if(index-this.printerList.get(i).getRows()<0)
			{
				return this.printerList.get(i).getRowText(index);
			}
			else
			{
				index-=this.printerList.get(i).getRows();
			}
		}
		return "";
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		int max=0;
		for(int i=0;i<this.printerList.size();i++)
			if(max<this.printerList.get(i).getColumns())
			{
				max=this.printerList.get(i).getColumns();
			}
		return max;
	}
	public boolean add(Printable printable)
	{
		return this.printerList.add(printable);
	}
	public boolean remove(Printable printable)
	{
		return this.remove(printable);	
	}

	public  Printable getPrint()
	{
		Random r=new Random();
		int index=r.nextInt(this.printerList.size());
		return this.printerList.get(index);
	}
}
