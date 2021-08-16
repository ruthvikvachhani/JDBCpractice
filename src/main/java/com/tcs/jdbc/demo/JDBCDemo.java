package com.tcs.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.pattern.LoggerPatternConverter;



public class JDBCDemo {
	private static Logger logger = LogManager.getLogger(JDBCDemo.class);
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/practice";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		
		try(Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD); 
				Statement statement = connection.createStatement();){
//				statement.execute("INSERT INTO REGIONS VALUES(5,'australia')");
//				create();//create
//				retrieve(statement);
//				update(statement);
//				delete(statement);
				List<String> region = retriveList(statement,"a");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<String> retriveList(Statement statement, String string) throws SQLException {
		// TODO Auto-generated method stub
		private static Logger logger = LogManager.getLogger(JDBCDemo.class);
		System.out.println("SELECT * FROM REGIONS WHERE REGION_NAME LIKE '"+string+"%'");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS WHERE REGION_NAME LIKE '"+string+"%'");
		List<String> list = new ArrayList<>();
		while(resultSet.next()) {
			logger.debug(resultSet.getInt(1)+"");
			System.out.println(resultSet.getInt(1)+"");
			System.out.println(resultSet.getNString(2)+"");
			list.add(resultSet.getNString(string));
		}
		System.out.println("");
		return list;
	}

	private static void delete(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.executeUpdate("DELETE FROM REGIONS WHERE REGION_ID = 5");
	}

	private static void update(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.executeUpdate("UPDATE REGIONS SET REGION_NAME = 'Russia' WHERE REGION_ID = 1");
		
		
	}

	private static void retrieve(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getNString("REGION_NAME"));
		}
	}

	private static void create(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.execute("INSERT INTO REGIONS VALUES(6,'antratica')");
	}
}
