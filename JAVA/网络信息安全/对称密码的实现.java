package ������Ϣ��ȫ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/*
 * 
 * 
 * 1���Գ����뼼����ʵ��
��1����Ϥ��Ӧ��DES����/���ܺ�����ʹ�ã��ڵ�����ɶ��ض��ļ���test-1.txt���ĵ���DES����/���ܣ�
��2�����DES��Կ�ص㣨8�ֽڣ�64����λ���������������õ�Ϊ56����λ�������һ��һ�ܵ���Կ�������ƣ���ÿ�λỰ��ʹ�õ���Կ������ʱ��������ģ���
 */
public class �Գ������ʵ�� {
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="";
		
		File file=new File("D:\\��ҵ\\������Ϣ��ȫ\\ʵ��2-1��ʱ��_2017-9-27 ����3-4�ڣ�\\test-1.txt");
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String temp;
		while((temp=reader.readLine())!=null)
		{
			str+=temp;
		}
		
		//���� ����Ҫ��8�ı���
		String password="95880280";
		byte[] result=encrypt(str.getBytes(),password);
		System.out.println("���ܺ�"+new String(result));
		
		byte[] decryResult=decrypt(result,password);
		System.out.println("���ܺ�:"+new String(decryResult));
		
	}
	
	
	public static byte[] encrypt(byte[] datasource,String password) {
		SecureRandom random=new SecureRandom();
		try {
			DESKeySpec desKey=new DESKeySpec(password.getBytes());
			//����һ���ܳ׹���
			SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
			SecretKey secureKey=keyFactory.generateSecret(desKey);
			
			//Cipher����ʵ����ɼ��ܲ���
			Cipher cipher=Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secureKey,random);
			
			return cipher.doFinal(datasource);
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static byte[] decrypt(byte[] src,String password)
	{
		//DES�㷨Ҫ����һ�������˵������Դ
		SecureRandom random=new SecureRandom();
		
		try {
			DESKeySpec desKey =new DESKeySpec(password.getBytes());
			
			SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
			
			SecretKey secureKey=keyFactory.generateSecret(desKey);
			
			Cipher cipher=Cipher.getInstance("DES");
			
			cipher.init(Cipher.DECRYPT_MODE, secureKey,random);
			
			return cipher.doFinal(src);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
