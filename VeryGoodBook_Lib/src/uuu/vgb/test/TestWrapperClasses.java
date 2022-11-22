package uuu.vgb.test;

import java.util.Map;
import java.util.TreeMap;

public class TestWrapperClasses {

	public static void main(String[] args) {
		String qtyStr = "abcd";
		int qty = Integer.parseInt(qtyStr);
		System.out.println(qty);
		
		String priceStr = "123.45";
		double price = Double.parseDouble(priceStr);
		System.out.println(price);

		Map<String, Integer> cartMap = new TreeMap<>();
		cartMap.put("Java技術手冊", 3); //int->Integer物件: auto-boxing
		
		//Wrapper物件的boxing, unboxing
//		Integer five = new Integer(5); : //boxing
//		double price1 = 100;
//		double price2 = 1050;
//		
//		double amount1 =  price1 * five.intValue(); //Integer物件->int: unboxing
//		
//		Double totalAmount =  new Double(amount1 + price2 * 3);//boxing
//		double totalAmountWithFee = totalAmount.doubleValue() + 100;//Double物件->double: unboxing
		
		//Wrapper物件的auto-boxing, auto-unboxing(在JDK 5.0後)
		Integer five = 5; //auto-boxing
		Double six = 6.;
		double price1 = 100;
		double price2 = 1050;
			
		Double amount1 = price1 * five; //Integer物件five.intValue(): auto-unboxing, 然後再auto-boxing成Double物件
		
		Double totalAmount =  amount1 + price2 * 3;//auto-unboxing: amount1.dobuleValue(), 然後再auto-boxing成Double物件
		double totalAmountWithFee = totalAmount + 100;//Double物件->double: auto-unboxing
		
	}

}
