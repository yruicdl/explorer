package com.k2data.qa.spring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public Properties load(String path) throws FileNotFoundException, IOException{
		Properties props = new Properties();
		props.load(new BufferedReader(new FileReader(path)));
		return props;
	}

}
