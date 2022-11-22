package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Customer;

public class TestCustomer {	
	public static void main(String[] args) {
		int i = 1;
		System.out.println("i:"+i);			
		int j = i;
		System.out.println("j:"+j);//1
		
		j=100;
		System.out.println("j:"+j);//100
		System.out.println("i:"+i);//1		
		
		if(!Customer.checkROCId("a123123123")) {
			return;
		}
		
		Customer customer = new Customer();		
		customer.setId("a123123123");
		
		customer.setName(" 狄會貴                    ");
		//customer.password = "12345;lkj";
		customer.setPassword("123jkl");
		customer.setGender('M');
		
		//customer.birthday = LocalDate.of(10300, 5, 28);
		//customer.setBirthday(10300,5,28);		
		//customer.birthday = LocalDate.parse("+12010-12-09");		
		customer.setBirthday("2010-06-10");
		
		customer.setEmail("test@gmail.com");
		customer.setAddress("       台北市               ");
		//System.out.println(customer.id); //A123456789
		System.out.println(customer.getId()); //A123456789
		
		System.out.println("customer.name:"+customer.getName()); //狄會貴
		
		//System.out.println("password:"+customer.password); //asdf1234
		System.out.println("password:"+customer.getPassword()); //asdf1234
		
		System.out.println("gender:"+customer.getGender()); //M
		System.out.println("email:"+customer.getEmail()); //test@gmail.com
		
		//System.out.println("birthday:"+customer.birthday); //2010-02-28
		System.out.println("birthday:"+customer.getBirthday()); //2010-02-28
		
		System.out.println("address:"+customer.getAddress());//
		System.out.println("phone:"+customer.getPhone());//
		System.out.println("subscribed:"+customer.isSubscribed());//false		
//		Period period= Period.between(customer.birthday, LocalDate.now());
//		System.out.println(period); //for test
//		int age = period.getYears();
//		if(period.getMonths()>6) {
//			age=age+1;
//		}
//		System.out.println(age);
		System.out.println("getAge():"+customer.getAge() + "歲");
		System.out.println("*************************");
		System.out.println(customer);
		System.out.println("*************************");
		Customer mary = customer;
		System.out.println("mary.name: "+mary.getName()); //狄會貴
		mary.setName("Mary");
		System.out.println("mary.name: "+mary.getName()); //Mary
		System.out.println("customer.name:"+customer.getName()); //Mary		
	}
}
