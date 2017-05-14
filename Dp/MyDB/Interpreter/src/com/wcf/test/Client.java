package com.wcf.test;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chineseNum="¶þÊ®";
		Convertor conv=new Convertor(chineseNum);
		conv.convert();
		System.out.println(chineseNum+"->"+conv.getRoman());
		String s1="abcdef";
		String s2="";
		
		

	}

}
