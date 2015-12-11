package com.k2data.qa.mytest;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;


public class TestMockito {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		@SuppressWarnings("rawtypes")
//		List mockedList = mock(List.class);
//		mockedList.add("1");
//		mockedList.clear();
//		
//		verify(mockedList).add("1");
//		verify(mockedList).clear();
		
		//You can mock concrete classes, not only interfaces
		 LinkedList mockedList = mock(LinkedList.class);

		 //stubbing
		 when(mockedList.get(0)).thenReturn("first");
		 when(mockedList.get(1)).thenThrow(new RuntimeException());

		 //following prints "first"
		 System.out.println(mockedList.get(0));

		 //following throws runtime exception
		 try{
		 System.out.println(mockedList.get(1));
		 }catch(Exception e){
			 e.printStackTrace();
		 }

		 //following prints "null" because get(999) was not stubbed
		 System.out.println(mockedList.get(999));
		 
		 System.out.println("here");

		 //Although it is possible to verify a stubbed invocation, usually it's just redundant
		 //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
		 //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
		 verify(mockedList).get(-1);

	}

}
