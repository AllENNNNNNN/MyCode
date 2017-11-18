package ������Ϣ��ȫ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA���ܽ��� {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
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
		
		KeyPair keyPair=genKeyPair(1024);
		
		//��ȡ��˽Կ������base64��ʽ��ӡ����
		PublicKey publicKey=keyPair.getPublic();
		System.out.println("��Կ��"+new String(Base64.getEncoder().encode(publicKey.getEncoded())));
		
	    PrivateKey privateKey=keyPair.getPrivate();
	    System.out.println("˽Կ��"+new String(Base64.getEncoder().encode(privateKey.getEncoded())));
	    
	    //��Կ����
	    byte[] encryptedBytes=encrypt(str.getBytes(),publicKey);
	    System.out.println("��Կ���ܺ�:"+new String(encryptedBytes));
	    
	    //˽Կ����
	    byte[] decryptedBytes=decrypt(encryptedBytes,privateKey);
	    System.out.println("˽Կ���ܺ�:"+new String(decryptedBytes));
	    
	    encryptedBytes=encryptByPrivate(str.getBytes(),privateKey);
	    System.out.println("˽Կ���ܺ�:"+new String(encryptedBytes));
	    
	    
	    decryptedBytes=decryptByPublic(encryptedBytes,publicKey);
	    System.out.println("��Կ���ܺ�:"+new String(decryptedBytes));
		
		

	}
	
	//������Կ��
	public static KeyPair genKeyPair(int KeyLength) throws NoSuchAlgorithmException
	{
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		return keyPairGenerator.generateKeyPair();
	}
	
	//��Կ����
	public static byte[] encrypt(byte[] content,PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(content);
		
	}
	
	//˽Կ����
	public static byte[] decrypt(byte[] content,PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(content);
	}
	
	//˽Կ����
	public static byte[] encryptByPrivate(byte[] content,PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(content);
		
	}
	
	//��Կ����
	public static byte[] decryptByPublic(byte[] content,PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(content);
	}
	
	

}
