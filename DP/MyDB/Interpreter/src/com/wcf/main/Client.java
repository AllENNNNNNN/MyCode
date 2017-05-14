package com.wcf.main;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String chineseNum="twenty million three hundred thirty two thousand five hundred thirty two";
		Convertor conv=new Convertor(chineseNum);
		conv.convert();
		System.out.println(chineseNum+"->"+conv.getRoman());
		
		
		String chineseNum1="three hundred thirty two thousand five hundred thirty two million three hundred thirty two thousand five hundred thirty two";
		Convertor conv1=new Convertor(chineseNum1);
		conv1.convert();
		System.out.println(chineseNum1+"->"+conv1.getRoman());
		
		String chineseNum2="six billion twenty million three hundred thousand five hundred thirty two";
		Convertor conv2=new Convertor(chineseNum2);
		conv2.convert();
		System.out.println(chineseNum2+"->"+conv2.getRoman());
		
		
		String chineseNum3="twenty million three hundred thousand five hundred thirty two billion twenty million three hundred thousand five hundred thirty two";
		Convertor conv3=new Convertor(chineseNum3);
		conv3.convert();
		System.out.println(chineseNum3+"->"+conv3.getRoman());
		
		
		
	}

}
