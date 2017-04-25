package com.wcf.midware;

import java.util.ArrayList;
import java.util.Scanner;

import javax.jms.JMSException;



public class JMSClient {


	private String client=null;
	private DBHelper db=new DBHelper();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JMSClient jc=new JMSClient();
		jc.Load();
		jc.run();

	}
	
	public void Load()
	{
		System.out.println("请输入用户名和密码");
		Scanner sc=new Scanner(System.in);
		client=sc.next();
		String password=sc.next();
		if(this.db.hasClient(client))
		{
			System.out.println("登录成功！");
			this.run();
		}
		else
		{
			System.out.println("此用户名不存在");
			this.Load();
		}
	}
	
	public void run()
	{
		System.out.println("请选择:1.发布 2.收信  3.订阅  4.退出");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		switch(s)
		{
		case "1":this.publish();break;
		case "2":this.reciece();break;
		case "3":this.subscribe();break;
		default:
		}
	}
	
	public void publish()
	{
		System.out.println("请输入您要发布的标题");
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		System.out.println("请输入您要发布的内容");
		String msg=sc.nextLine();
		String topic=this.selectTopic();
		try {
			new TopicMessagePublisher(this.client,topic).publishMessages(msg, title);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.run();
		
	}
	
	public void reciece()
	{
		ArrayList<String> topicList=this.db.getTopic(client);
		System.out.print("您当前订阅的话题有：");
		for(int i=0;i<topicList.size();i++)
			System.out.print(topicList.get(i)+" ");
		System.out.println();
		System.out.println("收到以下信息");
		for(int i=0;i<topicList.size();i++)
		{
			String topic=topicList.get(i);
			try {
				new TopicMessageSubscriber(this.client,topic).subscribeMessages();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.run();
	}
	
	public void subscribe()
	{
	
		String topic=this.selectTopic();
		this.db.subscribe(client, topic);
	}
	
	public void test()
	{
		TopicMessagePublisher tp=new TopicMessagePublisher("MyClientID1","topic2");
		try {
			tp.publishMessages("test", "test");
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TopicMessageSubscriber ts=new TopicMessageSubscriber("MyClientID1","topic2");
		try {
			ts.subscribeMessages();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public String selectTopic()
	{
		System.out.println("请选择您要发布的话题:");
		System.out.println("1.topic1 2.topic2 3.topic3 4.topic4 5.topic5 6.topic6");
		Scanner sc=new Scanner(System.in);
		String select=sc.nextLine();
		String result="topic1";
		switch(select)
		{
		case "1":result="topic1";break;
		case "2":result="topic2";break;
		case "3":result="topic3";break;
		case "4":result="topic4";break;
		case "5":result="topic5";break;
		case "6":result="topic6";break;
		}
		return result;
	}

}
