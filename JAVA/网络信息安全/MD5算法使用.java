package ������Ϣ��ȫ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5�㷨ʹ�� {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
	    String str="";
		
		File file=new File("D:\\��ҵ\\������Ϣ��ȫ\\ʵ��2-1��ʱ��_2017-9-27 ����3-4�ڣ�\\test-1.txt");
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new FileReader(file));			String temp;
		while((temp=reader.readLine())!=null)
		{
			str+=temp;
		}
		
		System.out.println(EncodeerByMD5(str));

	}
	
	//������ϢժҪ
	public static String EncodeerByMD5(String str) throws NoSuchAlgorithmException
	{
		MessageDigest md5=MessageDigest.getInstance("MD5");
		return new String(Base64.getEncoder().encodeToString(md5.digest((str.getBytes()))));
	}

}
