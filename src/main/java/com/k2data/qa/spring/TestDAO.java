package com.k2data.qa.spring;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDAO {
	
	public String getValueByKey(String key) throws FileNotFoundException, IOException{
		TestProperties tp = new TestProperties();
		Properties props = tp.load("src/test/resources/test.properties");
		return props.getProperty(key);
	}

}
