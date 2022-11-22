package uuu.vgb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.exception.VGBException;

class MySQLConnection {
	private static final String driver = System.getProperty("driver", "com.mysql.cj.jdbc.Driver");
	private static final String url = System.getProperty("url", "jdbc:mysql://localhost:3306/vgb");
	private static final String userid = System.getProperty("userid", "root");
	private static final String pwd = System.getProperty("pwd", "1234");
	
	static Connection getConnection() throws VGBException{
		try {
			Class.forName(driver); //1.載入Driver			
			try {
				Connection connection = 
					DriverManager.getConnection(url, userid, pwd);//2.建立連線
				return connection;
			} catch (SQLException e) {				
				throw new VGBException("建立連線失敗", e);
			}
		} catch (ClassNotFoundException e) {
//			Logger.getLogger("MSQLConnection").log(
//					Level.SEVERE, "載入Driver失敗", e);
			throw new VGBException("載入JDBC Driver失敗", e);
		}
	}	
}