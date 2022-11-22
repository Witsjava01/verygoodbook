package uuu.vgb.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;

import java.sql.*;

/**
 * 沒有使用避免SQL Injection攻擊的技巧
 * @author Admin
 *
 */
public class TestCustomerLogin {
	private static final String driver = System.getProperty("driver", "com.mysql.cj.jdbc.Driver");
	private static final String url = System.getProperty("url", "jdbc:mysql://localhost:3306/vgb");
	private static final String userid = System.getProperty("userid", "root");
	private static final String pwd = System.getProperty("pwd", "1234");
	
	private static String SELECT_CUSTOMER = "SELECT id,password,name,gender,email,birthday,"
			+ "address,phone,subscribed,discount "
			+ "FROM customers";	

	public static void main(String[] args){
		//1.輸入
		Scanner scanner = new Scanner(System.in);		
		System.out.println("請輸入帳號:");		
		String id = scanner.next(); // 'OR''='
		
		System.out.println("請輸入密碼:");
		String password =scanner.next(); // 'OR''='
		
		//2.執行商業邏輯(以下為JDBC 查詢)
		String sql = SELECT_CUSTOMER + " WHERE id='" + id + "' AND password='" + password + "'"; 
		Customer c = null;
		try {
			Class.forName(driver);//1.載入Driver			 
			
			try (
					Connection connection = DriverManager.getConnection(url,userid, pwd);	//2.建立連線
					Statement stmt = connection.createStatement();				//3.建立指令(Statement)
					ResultSet rs = stmt.executeQuery(sql); //4. 執行指令
				){				
				System.out.println("以下為查詢結果:");
				//5.處理rs
				while(rs.next()) {
					c = new Customer();
					c.setId(rs.getString("id"));
					c.setPassword(rs.getString("password"));					
					c.setName(rs.getString("name"));
					
					c.setGender(rs.getString("gender").charAt(0));
					
					c.setEmail(rs.getString("email"));
					c.setBirthday(rs.getString("birthday"));
					
					c.setAddress(rs.getString("address"));
					c.setPhone(rs.getString("phone"));
					c.setSubscribed(rs.getBoolean("subscribed"));
					System.out.println("折扣:" + rs.getInt("discount"));							
					System.out.println("********************************");
				}
			} catch (SQLException e) {
				Logger.getLogger("查詢全部客戶示範").log(Level.SEVERE, "資料庫連線|執行指令|讀取rs失敗", e);
			}
			
			//3.1 輸出正確結果
			System.out.println(c);
			
		} catch (ClassNotFoundException e) {
			//3.2 log錯誤訊息
			Logger.getLogger("查詢全部客戶示範").log(Level.SEVERE, "資料庫Driver載入失敗", e); //e.printStackTrace();
		}
	}
}
