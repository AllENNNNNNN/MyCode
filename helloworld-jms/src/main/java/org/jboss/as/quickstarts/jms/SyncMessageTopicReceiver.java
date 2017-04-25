package org.jboss.as.quickstarts.jms;

import java.util.Properties;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//同步接受者
public class SyncMessageTopicReceiver {

	/**
	 * @功能：发布-订阅消息服务   同步接收者
	 * @作者：
	 * @日期：2012-10-18
	 */

	private TopicSubscriber subscriber ;
	private TextMessage msg;
	private   Logger log = Logger.getLogger(HelloWorldJMSClient.class.getName());
	private   String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private   String DEFAULT_DESTINATION = "/jms/topics/topic1";
	private   String DEFAULT_USERNAME = "yaqiang";
	private   String DEFAULT_PASSWORD = "yaqiang";
	private   String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private   String PROVIDER_URL = "http-remoting://127.0.0.1:8080";
	public SyncMessageTopicReceiver() throws NamingException, JMSException
	{
		Context namingContext = null;


		String userName = System.getProperty("username", DEFAULT_USERNAME);
		String password = System.getProperty("password", DEFAULT_PASSWORD);

		// Set up the namingContext for the JNDI lookup
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
		env.put(Context.SECURITY_PRINCIPAL, userName);
		env.put(Context.SECURITY_CREDENTIALS, password);
		namingContext = new InitialContext(env);


		/*创建主题连接工厂*/
		TopicConnectionFactory tConFactory = (TopicConnectionFactory) 
				namingContext.lookup(DEFAULT_CONNECTION_FACTORY);
		/*创建一个主题*/
		Topic messageTopic = (Topic) namingContext.lookup(DEFAULT_DESTINATION);
		/*创建连接*/
		TopicConnection tCon = tConFactory.createTopicConnection(DEFAULT_USERNAME,DEFAULT_PASSWORD);
		/*创建会话*/
		TopicSession session = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		/*创建接收者*/
		subscriber = session.createSubscriber(messageTopic);
		tCon.start();	
	}
	public void runClient() throws JMSException
	{
		msg = (TextMessage) subscriber.receive();
		System.out.println("Receiver:"+msg.getText());
		msg = (TextMessage) subscriber.receive();
		System.out.println("Receiver:"+msg.getText());

	}
	public static void main(String[] args) throws NamingException, JMSException {
		SyncMessageTopicReceiver receiver = new SyncMessageTopicReceiver();
		receiver.runClient();
	}

}
