package com.wcf.midware;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.wcf.domain.CustomListener;


public class TopicMessageSubscriber {

	private static ConnectionFactory connectionFactory;

	private static Topic jmsTopic;

	private JMSContext jmsContext;
	
	private String topic;
	private String client;

	public TopicMessageSubscriber(String client,String topic) {
		this.client=client;
		this.topic=topic;
		try {
			this.setupResources();
			this.setupDestination();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void setupResources() throws NamingException {
		InitialContext iContext = new com.wcf.domain.MyInitialContext().Initial();
		connectionFactory = (ConnectionFactory)iContext.lookup("jms/RemoteConnectionFactory");
		jmsTopic = (Topic) iContext.lookup("/jms/topics/"+topic);
	}

	private void setupDestination() {
		jmsContext = connectionFactory.createContext("tangkai","tangkai");
		jmsContext.setClientID(this.client);
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

	}

}