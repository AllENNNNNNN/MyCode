package com.wcf.main;

import java.util.ArrayList;
import java.util.List;

public class ThousandExpression extends Expression{

	@Override
	public String getPostfix() {
		// TODO Auto-generated method stub
		return "thousand";
	}

	@Override
	public int muliplier() {
		// TODO Auto-generated method stub
		return 1000;
	}
	
	public void interpret(Context context)
	{
		List<Expression> exps=new ArrayList<Expression>();
		exps.clear();
		exps.add(new HundredExpression());
		exps.add(new GeExpression());
		
		String statement=context.getStatement();
		int index=statement.indexOf(this.getPostfix());
		if(index==-1) return;
		String substr=statement.substring(0, index);
		Context newContext=new Context(substr);
		//System.out.println("ThousandExpression.interpret:"+substr);
		for(Expression e:exps)
		{
			e.interpret(newContext);
		}
		context.setData(context.getData()+newContext.getData()*this.muliplier());
		context.setStatement(statement.substring(index+this.getPostfix().length()));
	//	System.out.println("ThousandExpression.interpret:"+context.getStatement());
	}

}
