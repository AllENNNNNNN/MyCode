package com.wcf;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable p=new ConcretePrinter();
		p.add(new FullBorder(new Printer()));
		p.add(new FullBorder(new FullBorder(new Printer())));
		p.add(new SideBorder(new FullBorder(new Printer()),'*'));
		p.setContext("Hello world!");
		System.out.println("三台打印机同时工作!");
		p.print();
		System.out.println("随机选择一台");
		Printable newp=p.getPrint();
		newp.setContext("test");
		newp.print();
	}

}
