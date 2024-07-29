/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.invoker;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.wildfly.naming.client.WildFlyInitialContextFactory;

/**
 *
 * @author bajinho
 */
public class Invoker {

    public static InitialContext getContext() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.URL_PKG_PREFIXES, "org.wildfly.naming");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, WildFlyInitialContextFactory.class.getName());
        properties.put(Context.PROVIDER_URL, "remote+http://127.0.0.1:8080");
//        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.SECURITY_PRINCIPAL, "ejbuser");
        properties.put(Context.SECURITY_CREDENTIALS, "5b3786b9989c762bb194680e06b6b9cc");
        return new InitialContext(properties);
    }
}
