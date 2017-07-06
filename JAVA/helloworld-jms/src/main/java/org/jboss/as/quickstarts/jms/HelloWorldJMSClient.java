/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.jms;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class HelloWorldJMSClient {


    // Set up all the default values

    public static void main(String[] args) {
      JMSControler jms=new JMSControler();
      jms.Send("haaha");
      try {
		receve();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    }
    
    public static void receve() throws NamingException, JMSException
    {
    	 int MAX_TRIES = 30;  
         int tryCount = 0;  
         AsyncMessageTopicReceiver receiver = new AsyncMessageTopicReceiver();  
         while (receiver.expectMoreMessage() && (tryCount < MAX_TRIES)) {  
               
             try {  
                // System.out.println(tryCount);  
                 Thread.sleep(1000);  
             } catch (InterruptedException e) {  
                 // TODO Auto-generated catch block  
                 e.printStackTrace();  
             }  
             tryCount++;  
         } 
    }
}
