package org.jboss.as.quickstarts.jms;

import java.util.Properties;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
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
//异步接收者
public class AsyncMessageTopicReceiver implements MessageListener {

	@SuppressWarnings("unused")
	private   Logger log = Logger.getLogger(HelloWorldJMSClient.class.getName());
	private   String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private   String DEFAULT_DESTINATION = "/jms/topics/topic1";
	private   String DEFAULT_USERNAME = "yaqiang";
	private   String DEFAULT_PASSWORD = "yaqiang";
	private   String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private   String PROVIDER_URL = "http-remoting://127.0.0.1:8080";
	private int EXPECTED_MESSAGE_COUNT = 10;  
	private int messageCount = 0;  
	private TopicSubscriber subscriber; 
	public AsyncMessageTopicReceiver() throws NamingException, JMSException {
		Context namingContext = null;

		try{
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
			/*创建一个主题*/  

			Topic messageTopic = (Topic) namingContext.lookup(DEFAULT_DESTINATION);  
			/*创建连接*/  
			TopicConnection tCon = tConFactory.createTopicConnection(DEFAULT_USERNAME,DEFAULT_PASSWORD);  
			/*创建会话*/  
			TopicSession session = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  
			/*创建接收者*/  
			TopicSubscriber subscriber = session.createSubscriber(messageTopic);  
			/* 设置监听 */  
			subscriber.setMessageListener(this);  
			tCon.start();  
		}
		catch(Exception e)
		{
			log.info(e.toString());
		}

	}

	public boolean expectMoreMessage() {  
        return messageCount < EXPECTED_MESSAGE_COUNT;  
    }  
  
    @Override  
    public void onMessage(Message message) {  
        System.out.println("onMessage");  
        try {  
            TextMessage msg = (TextMessage) message;  
            System.out.println("Receiver:" + msg.getText());  
        } catch (JMSException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
  
        messageCount++;  
    }  
    public static void main(String[] args) throws NamingException, JMSException {  
        int MAX_TRIES = 30;  
        int tryCount = 0;  
        AsyncMessageTopicReceiver receiver = new AsyncMessageTopicReceiver();  
        while (receiver.expectMoreMessage() && (tryCount < MAX_TRIES)) {  
              
            try {  
                System.out.println(tryCount);  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
            tryCount++;  
        }  
  
    }  
}

