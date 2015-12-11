package com.k2data.qa.mytest;

import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.Test;

public class TestBusinessLogic {
	
	@Test
	public void testbl1(){
		Value4Map mapobj = mock(Value4Map.class);
		when(mapobj.getSs1()).thenReturn("ss1 value");
		
		MyObject1 mockobj = mock(MyObject1.class);
		HashMap<String, Value4Map> map1 = new HashMap<String, Value4Map>();
		map1.put("key1", mapobj);
		when(mockobj.getMap()).thenReturn(map1);
		when(mockobj.getS1()).thenReturn("s1 value ");
		//doReturn("s1 value ").when(mockobj).getS1();
		when(mockobj.getS2()).thenReturn("s2 value ");
		when(mockobj.getS3()).thenReturn("s3 value ");
		
		BusinessLogic bl = new BusinessLogic();
		System.out.println(bl.bl1(mockobj));
		
	}

}
