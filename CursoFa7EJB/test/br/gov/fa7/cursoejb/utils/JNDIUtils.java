package br.gov.fa7.cursoejb.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIUtils {

	@SuppressWarnings("unchecked")
	public static <T> T lookup(String name) throws NamingException{
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447");
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context context = new InitialContext(properties);
		return (T) context.lookup(name);
	}
}
