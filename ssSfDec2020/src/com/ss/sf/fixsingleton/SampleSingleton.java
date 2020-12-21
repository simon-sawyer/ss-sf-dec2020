package com.ss.sf.fixsingleton;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleSingleton {
	
	private static Connection conn = null;

	private static volatile SampleSingleton instance = null;

	public static SampleSingleton getInstance() {
		if(instance != null){
			return instance;
		}else{
			instance = new SampleSingleton();
			return instance;
		}
	}

	public static void databaseQuery(BigDecimal input) {
		try{
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			int x = 0;
			while(rs.next()) {
				x = rs.getInt(1) * input.intValue();
			}
		}catch(Exception e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
