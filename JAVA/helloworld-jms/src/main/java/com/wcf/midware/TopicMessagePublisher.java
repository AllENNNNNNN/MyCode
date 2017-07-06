package com.wcf.midware;

import java.util.Date;
import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.wcf.domain.CustomListener;



public class TopicMessagePublisher{

	private ConnectionFactory connectionFactory;

	private Topic jmsTopic;

	private JMSContext jmsContext;

	private String Client;

	private String topic;

	public TopicMessagePublisher(String Client,String topic) {
		this.Client=Client;
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
		jmsTopic = (Topic) iContext.lookup("/jms/topics/"+this.topic);
	}

	private void setupDestination() {
		jmsContext = connectionFactory.createContext("jialong","jialong");
		jmsContext.setClientID(Client);
		jmsContext.setExceptionListener(new CustomListener());//监听异常
	}


	@SuppressWarnings("unused")
	public void publishMessages(String msg,String title) throws JMSException {
		if (msg == null || msg.isEmpty()) {
			return;
		}
		TextMessage message = jmsContext.createTextMessage(msg);
		message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
		message.setJMSDeliveryTime(new Date().getTime());
		message.setStringProperty("title", title);
		message.setStringProperty("Publisher", this.jmsContext.getClientID());
		message.setStringProperty("topic", this.topic);
		jmsContext.createProducer().setAsync(new CustomListener()).send(jmsTopic, message);//确定消息已成功发送
		jmsContext.close();
	}

	
	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}
}