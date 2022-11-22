package uuu.vgb.test;

import java.util.Scanner;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VIP;

public class TestEquals {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		System.out.println("請輸入Hello:");
		String s3 = scanner.next();		
		
		System.out.println("s1 == s2:" + (s1 == s2)); //false
		System.out.println("s2 == s3:" + (s2 == s3)); //false
		System.out.println("s1 == s3:" + (s1 == s3)); //false
		
		System.out.println("s1.equals(s2): " + s1.equals(s2)); //true
		System.out.println("s1.equals(s3): " + s1.equals(s3)); //true
		s2=s1;
		System.out.println("s1 == s2:" + (s1 == s2)); //true
		System.out.println("s1.equals(s2): "+s1.equals(s2)); //true
		
		Customer c1 = new Customer("A123456789", "54321;lk", "狄會");
		Customer c2 = new Customer("A123456789", "54321lk", "狄貴");
		VIP v = new VIP();
		v.setId("A123456789");
		
		System.out.println("c1 == c2:"+ (c1 == c2)); //false
		System.out.println("c1.equals(c2):"+c1.equals(c2)); //還沒寫Customer類別的equals方法時: false,已經在eqauls定義id為PKey:true 		
		System.out.println("c1 == v:"+ (c1 == v)); //false
		System.out.println("v.equals(c1):"+v.equals(c1)); //還沒寫Customer類別的equals方法時: false,已經在eqauls定義id為PKey:true 		
		c1 = c2;
		System.out.println("c1 == c2:"+ (c1 == c2)); //true
		System.out.println("c1.equals(c2):"+c1.equals(c2)); //true 		
		
		Product p1 = new Product(1, "Java SE 17 技術手冊", 680);
		Product p2 = new Product(1, "Java SE 17 技術手冊", 680);
		
		Outlet outlet = new Outlet();
		outlet.setId(1);
		outlet.setName("Java SE 17 技術手冊");
		outlet.setUnitPrice(680);
		outlet.setDiscount(1);
		
		Outlet outlet2 = new Outlet();
		outlet2.setId(1);
		outlet2.setName("Java SE 17 技術手冊");
		outlet2.setUnitPrice(680);
		outlet2.setDiscount(1);
		
		System.out.println("p1 == p2:"+ (p1 == p2)); //false
		System.out.println("p1.equals(p2):"+p1.equals(p2)); //還沒寫Product類別的equals方法時: false,已經在eqauls定義id為PKey:true 		
		System.out.println("p1 == outlet:"+ (p1 == outlet)); //false
		System.out.println("p1.equals(outlet):"+p1.equals(outlet));
		System.out.println("outlet2.equals(outlet):"+outlet2.equals(outlet)); //還沒寫Product類別的equals方法時: false,已經在eqauls定義id為PKey:true
		p1 = p2;
		System.out.println("p1 == p2:"+ (p1 == p2)); //true
		System.out.println("p1.equals(p2):"+p1.equals(p2)); //true 		
	}
}
