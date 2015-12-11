package com.k2data.qa.mytest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestBusinessLogicAnno {
	
	@Rule 
	public MockitoRule mockito = MockitoJUnit.rule();
	
	@Mock
	private Value4Map mapobj;
	
	@Mock
	private MyObject1 mockobj;
	
	
	@Test
	public void testbl1(){
		//Value4Map mapobj = mock(Value4Map.class);
		when(mapobj.getSs1()).thenReturn("ss1 value");
		
		//MyObject1 mockobj = mock(MyObject1.class);
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
