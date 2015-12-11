package com.k2data.qa.mytest;

import org.junit.ClassRule;
import org.junit.Test;

import com.k2data.qa.rules.K2Context;

public class TestRule1 {
	
	@ClassRule
	public static K2Context context = new K2Context();
	
	@Test
	public void test1(){
		context.add("key1", "value1");
	}
	
	@Test
	public void test2(){
		System.out.println(context.get("key1"));
	}

}
