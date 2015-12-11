package com.k2data.qa.mytest;

public class BusinessLogic {
	
	public String bl1(MyObject1 obj){
		String res = obj.getS1() + obj.getS2() + obj.getS3() + obj.getMap().get("key1").getSs1();
		return res;
	}

}
