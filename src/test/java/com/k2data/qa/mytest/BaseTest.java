package com.k2data.qa.mytest;

import org.junit.BeforeClass;

public class BaseTest {
	
	@BeforeClass
	public static void before(){
		System.out.println("In before class of base");
	}

}
