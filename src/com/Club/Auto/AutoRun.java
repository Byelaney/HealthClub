package com.Club.Auto;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Administrator
 *
 */
public class AutoRun implements ServletContextListener{

	private Timer timer = null;  
	
	 public void contextInitialized(ServletContextEvent arg0) {  
	        // TODO Auto-generated method stub  
		  
	        timer=new Timer(true);  
	        timer.schedule(new AutoCharge(),0,24* 3600*1000);//�ӳ�0�룬ÿ��ִ��һ��  
	    }  
	      
	    public void contextDestroyed(ServletContextEvent arg0) {  
	        // TODO Auto-generated method stub  
	        timer.cancel();  
	    }  

}
