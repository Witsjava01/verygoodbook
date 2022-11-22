package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class Test_instanceof {
	public static void main(String[] args) {
		Object o = new Object();
		Customer c = new Customer();
		VIP v = new VIP();
		String s = "";
		
		System.out.println(o instanceof Object);//true
		System.out.println(c instanceof Object);//true
		System.out.println(v instanceof Object);//true
		System.out.println(s instanceof Object);//true

		System.out.println(o instanceof Customer);//false
		System.out.println(c instanceof Customer);//true
		System.out.println(v instanceof Customer);//true
		//System.out.println(s instanceof Customer);//compile-time error
		
		System.out.println(o instanceof VIP);//false
		System.out.println(c instanceof VIP);//false
		System.out.println(v instanceof VIP);//true
		//System.out.println(s instanceof VIP);//compile-time error	
		
		System.out.println("*********************************************");
		Object o1 = null;
		Customer c1 = null;
		VIP v1 = null;
		String s1 = null;
		
		System.out.println(o1 instanceof Object);//false
		System.out.println(c1 instanceof Object);//false
		System.out.println(v1 instanceof Object);//false
		System.out.println(s1 instanceof Object);//false

		System.out.println(o1 instanceof Customer);//false
		System.out.println(c1 instanceof Customer);//false
		System.out.println(v1 instanceof Customer);//false
		//System.out.println(s1 instanceof Customer);//compile-time error
		
		System.out.println(o1 instanceof VIP);//false
		System.out.println(c1 instanceof VIP);//false
		System.out.println(v1 instanceof VIP);//false
		//System.out.println(s1 instanceof VIP);//compile-time error	
	}
}
