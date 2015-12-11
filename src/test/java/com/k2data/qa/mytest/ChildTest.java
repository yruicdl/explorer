package com.k2data.qa.mytest;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChildTest extends BaseTest{
	
	@BeforeClass
	public static void beforec(){
		System.out.println("In before class of child");
	}
	
	@Test
	public void test(){
		System.out.println("In test");
	}

}
