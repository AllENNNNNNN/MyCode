package com.wcf.main;

public class GeExpression extends Expression{

	@Override
	public String getPostfix() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int muliplier() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public  void interpret(Context context)
	{
		if(context.getStatement().length()==0)
			return;
		String statement=context.getStatement();
		String tail=this.getPostfix();
		int index=statement.indexOf(tail);
		int num=this.getNum(statement);
		context.setData(context.getData()+num*this.muliplier());
		context.setStatement(statement.substring(index+tail.length()));
		
	}
}
