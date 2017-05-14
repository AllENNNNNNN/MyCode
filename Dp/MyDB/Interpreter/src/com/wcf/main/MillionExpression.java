package com.wcf.main;

import java.util.ArrayList;
import java.util.List;

public class MillionExpression extends Expression{

	@Override
	public String getPostfix() {
		// TODO Auto-generated method stub
		return "million";
	}

	@Override
	public int muliplier() {
		// TODO Auto-generated method stub
		return 1000000;
	}
	
	public void interpret(Context context)
	{
		List<Expression> exps=new ArrayList<Expression>();
		exps.clear();
		exps.add(new ThousandExpression());
		exps.add(new HundredExpression());
		exps.add(new GeExpression());
		
		String statement=context.getStatement();
		int index=statement.indexOf(this.getPostfix());
		if(index==-1) return;
		String substr=statement.substring(0, index);
		Context newContext=new Context(substr);
	//	System.out.println("Million.interpret:"+substr);
		for(Expression e:exps)
		{
			e.interpret(newContext);
		}
		context.setData(context.getData()+newContext.getData()*this.muliplier());
		context.setStatement(statement.substring(index+this.getPostfix().length()));
	//	System.out.println("MillionExpression.interpret:"+context.getStatement());
	}

	
	

}
