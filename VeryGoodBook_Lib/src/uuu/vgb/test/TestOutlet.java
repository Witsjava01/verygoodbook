/**
 * 
 */
package uuu.vgb.test;

import uuu.vgb.entity.Outlet;

public class TestOutlet{
	public static void main(String[] args) {	
		//System.out.println(args.length);
		Outlet outlet = new Outlet(1,"Java SE 17技術手冊" ,680, 10);
//		outlet.setId(1);
//		outlet.setName("Java SE 17技術手冊");
//		outlet.setUnitPrice(680);
		outlet.setStock(3);
		outlet.setPhotoUrl("https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/37/0010923732.jpg&v=626bbe47a&w=348&h=348");
		outlet.setDescription("基於Java 17 LTS版本！涵蓋Java 15至17新特性:\n‧增加HTTP Client API介紹\n‧作者十幾年實務教育訓練中，匯整學員遇到的觀念、實作、應用等問題的經驗集合。\n‧必要時從Java SE API的原始碼分析，了解各語法在Java SE API中如何應用。");
		String dateStr = "2022-01-01";
		outlet.setLaunchDate(dateStr);
//		outlet.setDiscount(10); //10% off
		
		System.out.println("id:"+outlet.getId());//1
		System.out.println("name:"+outlet.getName());//基於Java 17 LTS版本！...
		System.out.println("定價:"+outlet.getListPrice()); //612
		System.out.println("折扣:"+outlet.getDiscountString()); //9折
		System.out.println("售價:"+outlet.getUnitPrice()); //612
		System.out.println("Stock:"+outlet.getStock()); //3
		System.out.println("PhotoUrl:"+outlet.getPhotoUrl());
		System.out.println("Description:"+outlet.getDescription());
		System.out.println("launchDate:"+outlet.getLaunchDate());
		System.out.println("Discount:"+outlet.getDiscount()); //10	
		
		//outlet = null; //for test
		System.out.println(outlet);
		
		System.out.println(Byte.parseByte("12"));
	}
}
