/**
 * 
 */
package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Product;

public class TestProduct {

	public static void main(String[] args) {	
		//System.out.println(args.length);
		Product p = new Product();
		p.setId(1);
		p.setName("Java SE 17技術手冊");
		p.setUnitPrice(680);
		p.setStock(3);
		p.setPhotoUrl("https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/37/0010923732.jpg&v=626bbe47a&w=348&h=348");
		p.setDescription("基於Java 17 LTS版本！涵蓋Java 15至17新特性:\n‧增加HTTP Client API介紹\n‧作者十幾年實務教育訓練中，匯整學員遇到的觀念、實作、應用等問題的經驗集合。\n‧必要時從Java SE API的原始碼分析，了解各語法在Java SE API中如何應用。");
		String dateStr = "2022-06-14";
		p.setLaunchDate(dateStr);
		System.out.println(p);
//		System.out.println("id:"+p.getId());//1
//		System.out.println("name:"+p.getName());//基於Java 17 LTS版本！...
//		System.out.println("unitPrice:"+p.getUnitPrice()); //680
//		System.out.println("Stock:"+p.getStock()); //3
//		System.out.println("PhotoUrl:"+p.getPhotoUrl());
//		System.out.println("Description:"+p.getDescription());
//		System.out.println("launchDate:"+p.getLaunchDate());
		
		System.out.println("*************************************");
		Product p2 = new Product(2, "最新Java程式語言 修訂第七版", 680);
		
		System.out.println("*************************************");
		Product p3 = new Product(3, "Java最強入門邁向頂尖高手之路：王者歸來(第二版)全彩版" //資料結構：使用Java
				, 1000, 8);

		System.out.println(p);//2
		System.out.println(p2);//2
		System.out.println(p3);//3
	}
}
