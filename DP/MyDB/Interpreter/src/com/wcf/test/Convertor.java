package com.wcf.test;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
	private Context context;
	private String chieseNum;
	int result;
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
		this.exps.add(new GeExpression());
		this.exps.add(new ShiExpression());
		this.exps.add(new BaiExpression());
		this.exps.add(new QianExpression());
		this.exps.add(new WanExpression());
		for(Expression e:this.exps)
		{
			e.interpret(context);
		}
		this.result=this.context.getData();
	}
	int getRoman()
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
