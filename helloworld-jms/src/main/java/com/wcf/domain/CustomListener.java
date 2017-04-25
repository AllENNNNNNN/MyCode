package com.wcf.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.jms.CompletionListener;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.wcf.midware.DBHelper;

/**
 * @author johnybasha
 *
 */
public class CustomListener implements MessageListener, ExceptionListener, CompletionListener{

	private String subscriber="null";
	public void onMessage(Message message) {
		try {
			System.out.println();
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String publisher=message.getStringProperty("Publisher");
			String delivertime=time.format(message.getJMSDeliveryTime());
			String recivetime=time.format(new Date());
			String topic=message.getStringProperty("topic");
			String title=message.getStringProperty("title");
			String context=((TextMessage)message).getText();
			System.out.println("发布者:    "+publisher);
			System.out.println("接受者:    "+this.subscriber);
			System.out.println("发布时间:   "+delivertime);
			System.out.println("接收时间:   "+recivetime);
			System.out.println("话题:      "+topic);
			System.out.println("标题:      "+title);
			System.out.println("内容:      " + context);
			System.out.println();
			String sql="insert into log values('"+publisher+"','"+this.subscriber+"','"+delivertime+"','"+recivetime+"','"+topic+"','"+title+"','"+context+"')";
			new DBHelper().exceSql(sql);
		} catch (JMSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			Enumeration<String> propNames = message.getPropertyNames();
			//message.getJMSDeliveryTime();
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//	System.out.println(time.format(message.getJMSDeliveryTime()));
			while(propNames.hasMoreElements()) {
				String propName = propNames.nextElement();
				Object propObj = message.getObjectProperty(propName);
				if (propObj != null) {
					//System.out.println("Property Name : " + propName);
					//System.out.println("Property Value : " + propObj);
				}
			}
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
/*
		try {
			message.acknowledge();
			System.out.println("Message Acknowledged ");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void onException(JMSException exception) {
		System.out.println("Exception Occured : " + exception.getMessage());

	}

	@Override
	public void onCompletion(Message message) {
		TextMessage tms=(TextMessage)message;
		try {
			System.out.println("Message Complete : " + tms.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void onException(Message message, Exception exception) {
		System.out.println("Exception Occured : " + message + " , :: "+ exception.getMessage());

	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

}