package uuu.vgb.service;

import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
class CustomersDAO {
	
	private final static String SELECT_CUSTOMER_BY_ID_OR_EMAIL = 
			"SELECT id,password,name,gender,email,birthday,"
			+ "address,phone,subscribed,discount "
			+ "FROM customers WHERE (id=? OR email=?)";	
	Customer selectCustomerByIdOrEmail(String idOrEmail) throws VGBException{
		Customer c = null;
		
		try(
			Connection connection = MySQLConnection.getConnection(); //1, 2. 取得連線
			PreparedStatement pstmt = connection.prepareStatement(
						 SELECT_CUSTOMER_BY_ID_OR_EMAIL);//3.準備指令
		  ) {
			//3.1 傳入?的值
			pstmt.setString(1, idOrEmail);
			pstmt.setString(2, idOrEmail);
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
			){
				//5.處理rs
				while(rs.next()) {
					
					int discount = rs.getInt("discount");
					if(discount>0) {
						c = new VIP();
						((VIP)c).setDiscount(discount);
					}else {
						c = new Customer();
					}
					c.setId(rs.getString("id"));
					c.setPassword(rs.getString("password"));
					c.setName(rs.getString("name"));
					c.setGender(rs.getString("gender").charAt(0));
					c.setEmail(rs.getString("email"));
					c.setBirthday(rs.getString("birthday"));
					
					c.setAddress(rs.getString("address"));					
					c.setPhone(rs.getString("phone"));
					c.setSubscribed(rs.getBoolean("subscribed"));					
				}
			}
			
		} catch (SQLException e) {
//			Logger.getLogger("CustomersDAO").log(
//					Level.SEVERE, "查詢客戶失敗", e);
			throw new VGBException("查詢客戶失敗", e);
		} 
		return c;		
	}
	
	
	private static final String INSERT_CUSTOMER="INSERT INTO customers"
			+ "(id,name, password, gender, email, birthday,"
			+ "		address, phone, subscribed)"
			+ "	VALUES(?,?,?,?,?,?,?,?,?)";
	void insert(Customer c) throws VGBException{	
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(INSERT_CUSTOMER); //3.準備指令
		){
			//3.1 傳入?的值
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getPassword());
			pstmt.setString(4, String.valueOf(c.getGender()));
			pstmt.setString(5, c.getEmail());
			pstmt.setString(6, String.valueOf(c.getBirthday()));
			
			pstmt.setString(7, c.getAddress());
			pstmt.setString(8, c.getPhone());
			pstmt.setBoolean(9, c.isSubscribed());
			
			pstmt.executeUpdate(); //4.執行指令
		} catch (SQLIntegrityConstraintViolationException e) {
			//1048, 1062, 1062:SQLIntegrityConstraintViolationException
			if(e.getMessage().indexOf("customers.PRIMARY")>=0) {
				throw new VGBDataInvalidException("帳號已重複註冊", e);
			}else if(e.getMessage().indexOf("customers.email_UNIQUE")>=0) {
				throw new VGBDataInvalidException("email已重複註冊", e);
			}else {
				throw new VGBException("新增客戶失敗", e);
			}
		} catch (SQLException e) {
			//SQLException: 1406:MysqlDataTruncation
			throw new VGBException("新增客戶失敗", e);
		}
	}
	
	private static final String UPDATE_CUSTOMER="UPDATE customers "
			+ " SET name=?, password=?, gender=?, email=?, birthday=?,"
			+ "	    address=?, phone=?, subscribed=?"
			+ "    WHERE id=?";
	void update(Customer c) throws VGBException{
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_CUSTOMER); //3.準備指令
			){
			//3.1 傳入?的值
			pstmt.setString(9, c.getId());
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getPassword());
			pstmt.setString(3, String.valueOf(c.getGender()));
			pstmt.setString(4, c.getEmail());
			pstmt.setString(5, String.valueOf(c.getBirthday()));
			
			pstmt.setString(6, c.getAddress());
			pstmt.setString(7, c.getPhone());
			pstmt.setBoolean(8, c.isSubscribed());
			
			pstmt.executeUpdate(); //4.執行指令
		} catch (SQLIntegrityConstraintViolationException e) {
			//1048, 1062:SQLIntegrityConstraintViolationException
			if(e.getMessage().indexOf("customers.email_UNIQUE")>=0) {
				throw new VGBDataInvalidException("email已重複註冊", e);
			}else {
				throw new VGBException("修改客戶失敗", e);
			}
		} catch (SQLException e) {
			//SQLException: 1406:MysqlDataTruncation
			throw new VGBException("修改客戶失敗", e);
		}
		
	}
}