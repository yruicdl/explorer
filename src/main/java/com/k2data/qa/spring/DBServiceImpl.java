package com.k2data.qa.spring;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBServiceImpl implements DBService {
	
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<Map<String,Object>> select(String sql) {
		return this.jdbcTemplate.queryForList(sql);
	}

	public void insert(String sql) {
		this.jdbcTemplate.execute(sql);
	}

}
