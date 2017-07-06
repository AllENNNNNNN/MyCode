package org.jboss.as.quickstarts.jms;

import java.util.Properties;
import java.util.logging.Logger;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSControler implements MessageListener {

	private   String DEFAULT_MESSAGE = "Hello, World!";
	private   String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private   String DEFAULT_DESTINATION = "/jms/topics/topic1";
	private   String DEFAULT_MESSAGE_COUNT = "1";
	private   String DEFAULT_USERNAME = "yaqiang";
	private   String DEFAULT_PASSWORD = "yaqiang";
	private   String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private   String PROVIDER_URL = "http-remoting://127.0.0.1:8080";
	private   Logger log = Logger.getLogger(HelloWorldJMSClient.class.getName());


	public void receive()
	{
		
	}

	public void Send(String message)
	{
		Context namingContext = null;

		try {
			String userName = System.getProperty("username", DEFAULT_USERNAME);
			String password = System.getProperty("password", DEFAULT_PASSWORD);

			// Set up the namingContext for the JNDI lookup
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
			env.put(Context.SECURITY_PRINCIPAL, userName);
			env.put(Context.SECURITY_CREDENTIALS, password);
			namingContext = new InitialContext(env);



			TopicConnectionFactory tConFactory = (TopicConnectionFactory)  
					namingContext.lookup(DEFAULT_CONNECTION_FACTORY);  


			Topic messageTopic = (Topic) namingContext.lookup(DEFAULT_DESTINATION);  

			TopicConnection tCon = tConFactory.createTopicConnection(DEFAULT_USERNAME,DEFAULT_PASSWORD);  

			TopicSession session = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  

			TopicPublisher publisher = session.createPublisher(messageTopic);  
			TextMessage  msg = session.createTextMessage();  
			msg.setText(message);  
			publisher.publish(msg);  
			msg.setText("Welcome to JMS!");  
			publisher.publish(msg);  
			System.out.println("成功！");  


		} catch (NamingException e) {
			log.severe(e.getMessage());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (namingContext != null) {
				try {
					namingContext.close();
				} catch (NamingException e) {
					log.severe(e.getMessage());
				}

			}
		}
	}

	public void test()
	{

	}
	public String getDEFAULT_MESSAGE() {
		return DEFAULT_MESSAGE;
	}
	public void setDEFAULT_MESSAGE(String dEFAULT_MESSAGE) {
		DEFAULT_MESSAGE = dEFAULT_MESSAGE;
	}
	public String getDEFAULT_CONNECTION_FACTORY() {
		return DEFAULT_CONNECTION_FACTORY;
	}
	public void setDEFAULT_CONNECTION_FACTORY(String dEFAULT_CONNECTION_FACTORY) {
		DEFAULT_CONNECTION_FACTORY = dEFAULT_CONNECTION_FACTORY;
	}
	public String getDEFAULT_DESTINATION() {
		return DEFAULT_DESTINATION;
	}
	public void setDEFAULT_DESTINATION(String dEFAULT_DESTINATION) {
		DEFAULT_DESTINATION = dEFAULT_DESTINATION;
	}
	public String getDEFAULT_USERNAME() {
		return DEFAULT_USERNAME;
	}
	public void setDEFAULT_USERNAME(String dEFAULT_USERNAME) {
		DEFAULT_USERNAME = dEFAULT_USERNAME;
	}
	public String getDEFAULT_MESSAGE_COUNT() {
		return DEFAULT_MESSAGE_COUNT;
	}
	public void setDEFAULT_MESSAGE_COUNT(String dEFAULT_MESSAGE_COUNT) {
		DEFAULT_MESSAGE_COUNT = dEFAULT_MESSAGE_COUNT;
	}
	public String getDEFAULT_PASSWORD() {
		return DEFAULT_PASSWORD;
	}
	public void setDEFAULT_PASSWORD(String dEFAULT_PASSWORD) {
		DEFAULT_PASSWORD = dEFAULT_PASSWORD;
	}
	public String getINITIAL_CONTEXT_FACTORY() {
		return INITIAL_CONTEXT_FACTORY;
	}
	public void setINITIAL_CONTEXT_FACTORY(String iNITIAL_CONTEXT_FACTORY) {
		INITIAL_CONTEXT_FACTORY = iNITIAL_CONTEXT_FACTORY;
	}
	public String getPROVIDER_URL() {
		return PROVIDER_URL;
	}
	public void setPROVIDER_URL(String pROVIDER_URL) {
		PROVIDER_URL = pROVIDER_URL;
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println("onMessage");  
		try {  
			TextMessage msg = (TextMessage) message;  
			System.out.println("Receiver:" + msg.getText());  
		} catch (JMSException e1) {  
			// TODO Auto-generated catch block  
			e1.printStackTrace();  
		}  

	}

}
