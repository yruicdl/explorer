package com.k2data.qa.mytest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.k2data.qa.spring.Contexts;
import com.k2data.qa.spring.TestService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(Parameterized.class)
@ContextConfiguration("/SpringTest-context.xml")
@TestPropertySource({"/dump.yaml","/test.properties"})
public class TestSpring {
	
	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();
	
	@Autowired
	private TestService ts;
	
	@Autowired
    Environment env;
	
	@Autowired
    private Contexts context;
	
	private String key;
	
//	@Value("${key1}")
//	private String propkey;
//	
//	@Bean  
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {  
//        return new PropertySourcesPlaceholderConfigurer();  
//    }  
	
//	public TestSpring(String key){
//		this.key = key;
//	}
//	
//	@Parameters
//	public static Collection<String[]> data(){
//		return Arrays.asList(new String[][] {
//				{"key1"},
//				{"key2"},
//		});
//	}
	
	@Test
	public void atest(){
		//			System.out.println(ts.getValueByKey(key));
////			System.out.println(propkey);
//			System.out.println(env.getProperty(key));
//			System.out.println(env.getProperty("pointDataQuery"));
//			
//			System.setProperty("mysys", "sysvalue");
//			System.out.println(env.getProperty("mysys"));
		context.add("key1", "value1");
		System.out.println("key1 is set!!!!!!!!!!!!!!!!!!!!!!");
		context.add("key2", "value2");
		System.out.println("key2 is set!!!!!!!!!!!!!!!!!!!!!!");
	}

}
