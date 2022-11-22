package uuu.vgb.test;

import java.util.Scanner;

import uuu.vgb.entity.Customer;

public class TestROCIDFirstChar {

	public static void main(String[] args) {
//		String idFirstCharSequence="ABCDEFGHJKLMNPQRSTUVXYWZIO";
//		System.out.println(idFirstCharSequence.indexOf('B'));

		System.out.println("enter ROC ID, please:");
		Scanner scanner = new Scanner(System.in);
		
		String id = scanner.next();
		Customer customer = new Customer();
		//customer.checkROCId(id);
		customer.setId(id);
		
		System.out.println(customer.getId());
	}

}
