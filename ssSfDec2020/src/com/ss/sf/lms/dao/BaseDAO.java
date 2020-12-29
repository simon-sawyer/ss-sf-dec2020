package com.ss.sf.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseDAO {

	PreparedStatement pstmt = null;
	public String driver = "com.mysql.jdbc.Driver" ;
	public String url = "jdbc:mysql://localhost:3306/library";
	public String username = "user1";
	public String password = "password1";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		for(int i = 0; i < vals.length; i++){
			pstmt.setObject(i, vals[i]);
		}
		pstmt.executeUpdate();
	}
}