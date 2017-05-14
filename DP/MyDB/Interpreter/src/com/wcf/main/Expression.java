package com.wcf.main;

import java.util.LinkedHashMap;
import java.util.Map;



public abstract class Expression {
	//数据字典：保存数组一到久
	protected  Map<String,Integer> table=new LinkedHashMap<String,Integer>();
	
	public Expression()
	{
		table.put("one", 1);
		table.put("two", 2);
		table.put("three", 3);
		table.put("four", 4);
		table.put("five", 5);
		table.put("six", 6);
		table.put("seven", 7);
		table.put("eight", 8);
		table.put("nine", 9);
		table.put("ten", 10);
		table.put("eleven", 11);
		table.put("twelve", 12);
		table.put("thirteen", 13);
		table.put("fourteen", 14);
		table.put("fifteen", 15);
		table.put("sixteen", 16);
		table.put("seventeen", 17);
		table.put("eighteen", 18);
	    table.put("nineteen", 19);
		table.put("twenty", 20);
		table.put("thirty", 30);
		table.put("forty", 40);
		table.put("fifty", 50);
		table.put("sixty", 60);
		table.put("seventy", 70);
		table.put("eighty", 80);
		table.put("ninety", 90);
		
		
	}
	protected boolean stringEndsWith(String src,String tail)
	{
		if(src.length()<tail.length())
			return false;
		int end=src.lastIndexOf(tail);
		System.out.println(src+"    "+tail);

		return end==(src.length()-tail.length());
	}
	public void interpret(Context context)
	{
		if(context.getStatement().length()==0)
			return;
		String statement=context.getStatement();
		String tail=this.getPostfix();
		int index=statement.indexOf(tail);
		if(index==-1) return;
		int num=this.getNum(statement.substring(0, index));
		context.setData(context.getData()+num*this.muliplier());
		context.setStatement(statement.substring(index+tail.length()));
		
	}
	
	public int getNum(String s)
	{
		int n=0;
		String []words=s.toLowerCase().split(" ");
		for(String word:words)
		{
			if(word.length()<3) continue;
			//System.out.println("getNum:"+word);
			//System.out.println(this.table.get("five"));
			n+=table.get(word);
			
		}
			return n;
	}
	public abstract String getPostfix();
	public abstract int muliplier();

}