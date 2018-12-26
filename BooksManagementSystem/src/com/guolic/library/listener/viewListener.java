package com.guolic.library.listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.guolic.library.util.PropertiesUtil;


public class viewListener implements ServletContextListener{

    public viewListener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // 读取views-mapping.properties
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("views-mapping.properties"));
            PropertiesUtil.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
