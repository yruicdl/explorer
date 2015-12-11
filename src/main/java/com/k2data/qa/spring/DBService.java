package com.k2data.qa.spring;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface DBService {
	
	public List<Map<String,Object>> select(String sql);
	
	public void insert(String sql);

}
