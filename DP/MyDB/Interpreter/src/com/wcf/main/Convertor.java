package com.wcf.main;

import java.util.ArrayList;
import java.util.List;


public class Convertor {
	private Context context;
	private String chieseNum;
	long result;
	private List<Expression> exps=new ArrayList<Expression>();
	
	public void reset()
	{
		this.context.setStatement(chieseNum);
		this.context.setData(0);
		this.exps.clear();
	}
	public Convertor(String chineseNum)
	{
		this.context=new Context(chineseNum);
		this.chieseNum=chineseNum;
		result=0;
	}
	public void convert()
	{
		this.reset();
		exps.add(new BillionExpression());
		exps.add(new MillionExpression());
		exps.add(new ThousandExpression());
		exps.add(new HundredExpression());
		exps.add(new GeExpression());
		
	
		for(Expression e:this.exps)
		{
			e.interpret(context);
		}
		this.result=this.context.getData();
	}
	long getRoman()
	{
		return this.result;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public String getChieseNum() {
		return chieseNum;
	}

	public void setChieseNum(String chieseNum) {
		this.chieseNum = chieseNum;
	}

	public List<Expression> getExps() {
		return exps;
	}

	public void setExps(List<Expression> exps) {
		this.exps = exps;
	}
	

}