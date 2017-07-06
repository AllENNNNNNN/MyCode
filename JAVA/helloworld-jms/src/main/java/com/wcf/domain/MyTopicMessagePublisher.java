package com.wcf.domain;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQTopic;



public class MyTopicMessagePublisher{

	private static ConnectionFactory connectionFactory;

	private static Topic jmsTopic;

	private static JMSContext jmsContext;

	public MyTopicMessagePublisher() {
		publish();
	}

	private void setupResources() throws NamingException, JMSException {
		InitialContext iContext = new MyInitialContext().Initial();
		connectionFactory = (ConnectionFactory)iContext.lookup("jms/RemoteConnectionFactory");
		Connection con=connectionFactory.createConnection("yaqiang","yaqiang");
		Session s=con.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		jmsTopic = new ActiveMQTopic("topic1");
		MessageProducer produce=s.createProducer(jmsTopic);
		produce.send(s.createTextMessage("0"));
		iContext.close();
	}

	private void setupDestination() {
		jmsContext = connectionFactory.createContext("yaqiang","yaqiang");
		jmsContext.setClientID("MyClientID4");
		jmsContext.setExceptionListener(new CustomListener());//监听异常
	}


	private void publishMessages(String msg) throws JMSException {
		if (msg == null || msg.isEmpty()) {
			return;
		}
		TextMessage message = jmsContext.createTextMessage(msg);
		message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
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
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void main(String[] args) {
		new MyTopicMessagePublisher();//.publishMessages("Message from Publisher"); 
	}
}