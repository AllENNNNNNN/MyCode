package com.wcf.domain;

import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class TopicMessagePublisher{

	private static ConnectionFactory connectionFactory;

	private static Topic jmsTopic;

	private static JMSContext jmsContext;

	private String Client;

	public TopicMessagePublisher(String Client) {
		this.Client=Client;
		publish();
	}

	private void setupResources() throws NamingException {
		InitialContext iContext = new MyInitialContext().Initial();
		connectionFactory = (ConnectionFactory)iContext.lookup("jms/RemoteConnectionFactory");
		jmsTopic = (Topic) iContext.lookup("/jms/topics/topic1");
	}

	private void setupDestination() {
		jmsContext = connectionFactory.createContext("jialong","jialong");
		jmsContext.setClientID(Client);
		jmsContext.setExceptionListener(new CustomListener());//监听异常
	}


	private void publishMessages(String msg,String title) throws JMSException {
		if (msg == null || msg.isEmpty()) {
			return;
		}
		TextMessage message = jmsContext.createTextMessage(msg);
		message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
		message.setJMSDeliveryTime(new Date().getTime());
		message.setStringProperty("title", "helloWorld");
		message.setStringProperty("Publisher", this.jmsContext.getClientID());
		jmsContext.createProducer().setAsync(new CustomListener()).send(jmsTopic, message);//确定消息已成功发送
		jmsContext.close();
	}

	private void publish() {

		try {
			this.setupResources();
			this.setupDestination();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void main(String[] args) {
		try {
			
			new TopicMessagePublisher("MyClientID1").publishMessages("Message from Publisher","HelloWorld");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}
}