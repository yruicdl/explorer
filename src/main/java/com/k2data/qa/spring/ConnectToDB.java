package com.k2data.qa.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConnectToDB {

	// private static java.sql.Connection ;
	private static java.sql.PreparedStatement preparedStatement;
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @param db
	 * @param user
	 * @param pwd
	 * @return
	 */
	public static Connection getMysqlConnection(String host,String port,String db,String user,String pwd){
		
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			connection = DriverManager.getConnection(
					"jdbc:mysql://"+host+":"+port+"/"+db, user,
					pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			connection = DriverManager.getConnection(
					"jdbc:mysql://192.168.130.44:3306/mysql", "admin",
					"passw0rd");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ResultSet executeQuery(Connection connection, String sql,
			LinkedList<Object> params) {
		try {
			preparedStatement = connection.prepareStatement(sql);
			if (params != null) {
				int i = 1;
				for (Object p : params) {
					preparedStatement.setObject(i++, p);
				}
			}
			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet executeQuery(Connection connection, String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);

			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {

		System.out.println(getAllProjects().size());
		// System.out.println(getAllProjects().get(1)[1].toString());
		for (int i = 0; i < getAllProjects().size(); i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(getAllProjects().get(i)[j].toString());
			}
		}

	}

	public static ArrayList<String[]> getAllProjects() throws SQLException {

		ArrayList<String[]> prjs = new ArrayList<String[]>();
		Connection conn = ConnectToDB.getConnection();
		ResultSet rs = ConnectToDB.executeQuery(conn,
				"select * from project order by PID ASC");

		while (rs.next()) {

			prjs.add(new String[] { rs.getString("PID"), rs.getString("name"),
					rs.getString("type"), rs.getString("timestamp"),
					rs.getRow() + "" });
		}

		rs.close();
		conn.close();
		return prjs;

	}

	/**
	 * 
	 * @param conn
	 * @param sqlList
	 */
	public static void executeBatchSQL(Connection conn, List<String> sqlList) {

		try {

			Statement smt = conn.createStatement();

			for (String sql : sqlList) {
				smt.addBatch(sql);
			}
			int[] a=smt.executeBatch();
//			conn.commit();
			smt.close();
			System.out.println("exec = "+a.length);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
