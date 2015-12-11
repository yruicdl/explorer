package com.k2data.qa.mytest;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class MyLogger extends Logger {
	
	private static ArrayList<String> steps = new ArrayList<String>();

	protected MyLogger(String name) {
		super(name);
	}
	
	static
	  public
	  MyLogger getMyLogger(Class<?> clazz) {
	    return (MyLogger) LogManager.getLogger(clazz.getName(),new LoggerFactory(){
			public MyLogger makeNewLoggerInstance(String name) {
				return new MyLogger(name);
			}
	    	
	    });
	  }
	
	public void step(String step, String ExpectedResult){
		this.info(step);
		steps.add(step);
	}
	
	public void testcase(){
		Iterator<String> it = steps.iterator();
		while(it.hasNext()){
			this.info("[Testcase step] "+it.next().toString());
		}
	}

}
