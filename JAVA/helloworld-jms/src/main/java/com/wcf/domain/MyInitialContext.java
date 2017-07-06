package com.wcf.domain;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyInitialContext {

	private   String DEFAULT_USERNAME = "yaqiang";
	private   String DEFAULT_PASSWORD = "yaqiang";
	private   String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private   String PROVIDER_URL = "http-remoting://127.0.0.1:8080";

	public InitialContext Initial() throws NamingException
	{
		String userName = System.getProperty("username", DEFAULT_USERNAME);
		String password = System.getProperty("password", DEFAULT_PASSWORD);

		// Set up the namingContext for the JNDI lookup
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
		env.put(Context.SECURITY_PRINCIPAL, userName);
		env.put(Context.SECURITY_CREDENTIALS, password);
		return new InitialContext(env);
	}

}
