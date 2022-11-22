package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Customer;

public class TestCustomerConstructor {

	public static void main(String[] args) {
		Customer c = new Customer("A123123123", "12345;lk", "張三豐");
//		c.setId("A123123123");
//		c.setPassword("12345;lkj");
//		c.setName("張三豐");

		System.out.println("id:" + c.getId());
		System.out.println("password:" + c.getPassword());
		System.out.println("name:" + c.getName());
		System.out.println(c.toString());
		
		Customer c1 = 
				new Customer("A123123123", "12345;lk", "張三豐",
						'M', "test@gmail.com", "2010-01-01");
	}

}
