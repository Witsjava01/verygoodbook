package uuu.vgb.test;

import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class TestPolymorphism {

	public static void main(String[] args) {
		Object o;
		o = new Object(); //normal referance type declaration		
		String s = "Hello"; //normal referance type declaration
		o = s;
		System.out.println(s.length());  //5
		System.out.println(s.toString());  //Hello
		
		Object o1 = "Hello"; //polymorphic referance type declaration
		System.out.println(((String)o1).length());
		
		o1 = new Customer("A123456789", "asdf1234", "John");		
		System.out.println(((Customer)o1).getName());
		
		if(o1 instanceof String) {
			System.out.println("o1轉型回String後，字串的length():"+ ((String)o1).length());
		}else if(o1 instanceof Customer) {
			Customer c = (Customer)o1;
			c.setName("John");
			System.out.println(c==o1);
			System.out.println("o1轉型回Customer後，客戶的getName():"+((Customer)o1).getName());
		}
		System.out.println(o1.toString()); //Hello 
		
//		List<Product> cList = new ArrayList<>();
//		cList.add(new Outlet());
	}

}
