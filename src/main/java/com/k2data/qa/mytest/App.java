package com.k2data.qa.mytest;

import java.sql.Timestamp;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static MyLogger log = MyLogger.getMyLogger(App.class);
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        long l = 1000L;
//        Long L = new Long(1000L);
//        //L.byteValue();
//        System.out.println(L.byteValue());
//        String s = "ss";
//        s.getBytes();
//        Integer i = new Integer(1);
//        i.byteValue();
        
//        log.step("step1","expected1");
//        
//        log.info("info");
//        log.debug("debug");
//        log.error("error");
//        
//        log.step("step2","expected2");
//        
//        log.step("step3","expected2");
//        
//        log.testcase();
        
//        System.out.println(StaticTest.staticfield);
        
        Timestamp ts = new Timestamp(1367341200000l);
        System.out.println(ts);
        
    }
}
