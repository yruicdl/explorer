package com.k2data.qa.rules;

import java.util.HashMap;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class K2Context implements TestRule{
	
	public HashMap<String, Object> context = new HashMap<String, Object>();

	@Override
	public Statement apply(Statement base, Description description) {
		return k2stmt(base);
	}
	
	private Statement k2stmt(final Statement base){
		return new Statement(){

			@Override
			public void evaluate() throws Throwable {
				// TODO Auto-generated method stub
				base.evaluate();
			}
			
		};
		
	}
	
	public void add(String key, Object value){
		this.context.put(key, value);
	}
	
	public Object get(String key){
		return this.context.get(key);
	}

}
