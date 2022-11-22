package uuu.vgb.test;

import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.ShippingType;

public class TestEnumPaymentTypeShippingType {

	public static void main(String[] args) {
		PaymentType atm = PaymentType.ATM;
		
		System.out.println(atm);
		System.out.println(PaymentType.ATM);
		System.out.println("***付款方式: ************");
		PaymentType[] pArray = PaymentType.values();
		for(PaymentType pType:pArray) {
			System.out.println(pType.toString());
			System.out.println(pType.ordinal());
			System.out.println(pType.name());
		}
		System.out.println("***貨運方式: ************");		
		ShippingType[] shArray = ShippingType.values();
		for(ShippingType shType:shArray) {
			System.out.println(shType.toString());
			System.out.println(shType.ordinal());
			System.out.println(shType.name());
		}
	}

}
