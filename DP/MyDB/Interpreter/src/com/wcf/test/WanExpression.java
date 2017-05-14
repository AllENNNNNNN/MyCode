package com.wcf.test;

import java.util.ArrayList;
import java.util.List;

public class WanExpression extends Expression{

	@Override
	public String getPostfix() {
		// TODO Auto-generated method stub
		return "Íò";
	}

	@Override
	public int muliplier() {
		// TODO Auto-generated method stub
		return 10000;
	}
	
	public void interpret(Context context)
	{
		if(context.getStatement().length()==0)
			return;
		if(stringEndsWith(context.getStatement(),this.getPostfix()))
		{
			List<Expression> exps=new ArrayList<Expression>();
			exps.clear();
			exps.add(new GeExpression());
			exps.add(new ShiExpression());
			exps.add(new BaiExpression());
			exps.add(new QianExpression());
			int temp=context.getData();
			String sm=context.getStatement();
			context.setData(0);
			context.setStatement(sm.substring(0,sm.length()-2));
			for(Expression e:exps)
			{
				e.interpret(context);
				
			}
			context.setData(temp+this.muliplier()*context.getData());
			exps.clear();
		}
	}

}
