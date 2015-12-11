package com.k2data.qa.spring;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class TestService {
	
	@Autowired
	private TestDAO testdao;
	
	public String getValueByKey(String key) throws FileNotFoundException, IOException{
		return testdao.getValueByKey(key);
	}

}
