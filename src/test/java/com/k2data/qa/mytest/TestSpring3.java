package com.k2data.qa.mytest;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.k2data.qa.spring.DBServiceImpl;

@ContextConfiguration("/SpringTest-context.xml")
@Transactional
//@Commit
public class TestSpring3{
	
	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();
	
	@Autowired
	DBServiceImpl service;
	
//	@Autowired
//	ApplicationContext appCtx;
	
	@BeforeTransaction
	public void bftx(){
		Iterator<Map<String, Object>> it = service.select("select * from springtest1").iterator();
		while(it.hasNext()){
			Map<String, Object> item = it.next();
			System.out.println(item.get("c1"));
		}
		System.out.println("---------bftx end------------");
	}
	
//	@Test
//	public void ctxTest(){
//		appCtx
//	}
	
	//@Test
	//@Rollback
	public void updatedb() throws SQLException{
		//DBServiceImpl service = new DBServiceImpl();
		service.insert("insert into springtest1 values (2)");
		Iterator<Map<String, Object>> it = service.select("select * from springtest1").iterator();
		while(it.hasNext()){
			Map<String, Object> item = it.next();
			System.out.println(item.get("c1"));
		}
		System.out.println("---------test end------------");
	}
	
	@Test
	@Sql("/test.sql")
	public void updatedbscripts(){
		Iterator<Map<String, Object>> it = service.select("select * from springtest1").iterator();
		while(it.hasNext()){
			Map<String, Object> item = it.next();
			System.out.println(item.get("c1"));
		}
		System.out.println("---------test end------------");
	}
	
	@AfterTransaction
	public void afttx(){
		Iterator<Map<String, Object>> it = service.select("select * from springtest1").iterator();
		while(it.hasNext()){
			Map<String, Object> item = it.next();
			System.out.println(item.get("c1"));
		}
		System.out.println("---------afttx end------------");
	}

}
