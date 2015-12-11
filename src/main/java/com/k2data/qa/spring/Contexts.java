package com.k2data.qa.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Contexts {
	
	Map<String,Object> context = new ConcurrentHashMap<String,Object>(64);
	
	public void add(String key, Object value){
		if(context!=null){
			context.put(key, value);
		}
	}
	
	public Object get(String key){
		if(context!=null){
			return context.get(key);
		}
		else
			return null;
	}

}
