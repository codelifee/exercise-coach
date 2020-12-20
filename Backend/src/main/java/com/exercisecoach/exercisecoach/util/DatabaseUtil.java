package com.exercisecoach.exercisecoach.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	public static Connection getConnection() {
		try {
			String driver="oracle.jdbc.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			
			String user="week7";
			String pwd="week7";
			
			Class.forName(driver);
			return DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
