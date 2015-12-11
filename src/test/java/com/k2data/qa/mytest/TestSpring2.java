package com.k2data.qa.mytest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.k2data.qa.spring.Contexts;

@ContextConfiguration("/SpringTest-context.xml")
@TestPropertySource({"/dump.yaml","/test.properties"})
public class TestSpring2 {
	
	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();
	
	@Autowired
	static
    Environment env;
	
	@Autowired
    private Contexts context;
	
//	@BeforeClass
//	public static void setup(){
//		System.out.println("in before -------------------------" + env.getProperty("key1"));
//	}
	
	@Test
	public void atest2(){
		try {
//			System.out.println(ts.getValueByKey(key));
//			System.out.println(propkey);
//			System.out.println(env.getProperty("key1"));
//			System.out.println(env.getProperty("pointDataQuery"));
//			
//			System.setProperty("mysys", "sysvalue");
//			System.out.println(env.getProperty("mysys"));
			context.add("key3", "value3");
			System.out.println("key3 is set!!!!!!!!!!!!!!!!!!!!!!");
			
			System.out.println(context.get("key1"));
			System.out.println(context.get("key2"));
			System.out.println(context.get("key3"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
