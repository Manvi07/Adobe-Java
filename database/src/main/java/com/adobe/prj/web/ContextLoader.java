package com.adobe.prj.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

 
@WebListener
public class ContextLoader implements ServletContextListener {
 
    public ContextLoader() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("======> application is deployed");
    }
	
}
