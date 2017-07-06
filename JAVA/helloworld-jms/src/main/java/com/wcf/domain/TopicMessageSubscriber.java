package com.wcf.domain;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class TopicMessageSubscriber {

	private static ConnectionFactory connectionFactory;

	private static Topic jmsTopic;

	private static JMSContext jmsContext;

	public TopicMessageSubscriber() {
		this.subscribe();
	}

	private void setupResources() throws NamingException {
		InitialContext iContext = new MyInitialContext().Initial();
		connectionFactory = (ConnectionFactory)iContext.lookup("jms/RemoteConnectionFactory");
		jmsTopic = (Topic) iContext.lookup("/jms/topics/topic1");
	}

	private void setupDestination() {
		jmsContext = connectionFactory.createContext("tangkai","tangkai");
		jmsContext.setClientID("MyClientID2");
		jmsContext.setExceptionListener(new CustomListener());//监听是否发生异常
	}

	public void subscribeMessages() throws JMSException {
		CustomListener listener=new CustomListener();
		listener.setSubscriber(this.jmsContext.getClientID());
		jmsContext.createDurableConsumer(jmsTopic, "MyDurableSubscrb").setMessageListener(listener);
		//创建一个耐用的监听器,MyDurableSubscrb是订阅者Id
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jmsContext.close();
		/**
		jmsContext.createConsumer(jmsTopic).setMessageListener(new CustomListener());
		Message message = jmsContext.createConsumer(jmsTopic).receive();
		if (message != null && message instanceof TextMessage) {
			System.out.println("Message Received : " + ((TextMessage)message).getText());
		}
		 */
	}

	private void subscribe() {
		try {
			this.setupResources();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setupDestination();
	}


	public static void main(String[] args) {
		try {
			new TopicMessageSubscriber().subscribeMessages();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}