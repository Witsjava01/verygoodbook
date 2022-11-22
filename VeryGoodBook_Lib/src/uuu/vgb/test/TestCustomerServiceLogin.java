package uuu.vgb.test;

import java.util.Scanner;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

/**
 * 已經可以避免SQL Injection攻擊
 * @author Admin
 *
 */
public class TestCustomerServiceLogin {
	private static final String driver = System.getProperty("driver", "com.mysql.cj.jdbc.Driver");
	private static final String url = System.getProperty("url", "jdbc:mysql://localhost:3306/vgb");
	private static final String userid = System.getProperty("userid", "root");
	private static final String pwd = System.getProperty("pwd", "1234");
	
	private final static String SELECT_CUSTOMER = "SELECT id,password,name,gender,email,birthday,"
			+ "address,phone,subscribed,discount "
			+ "FROM customers WHERE id=? OR email=?";	

	public static void main(String[] args) throws VGBException{
		//1.輸入
		Scanner scanner = new Scanner(System.in);		
		System.out.println("請輸入帳號或Email:");		
		String id = scanner.next(); // 'OR''='
		
		System.out.println("請輸入密碼:");
		String password =scanner.next(); // 'OR''='
		
		//2.執行商業邏輯(以下為JDBC 查詢)		 
		CustomerService service = new CustomerService();
		Customer c = service.login(id, password);
			
		//3.1 輸出正確結果
		System.out.println(c!=null?c.getName()+"登入成功!":"登入失敗");
			
		
	}
}
