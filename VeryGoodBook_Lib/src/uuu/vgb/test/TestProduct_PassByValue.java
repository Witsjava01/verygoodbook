package uuu.vgb.test;

import java.io.FileReader;

import uuu.vgb.entity.Product;

public class TestProduct_PassByValue {

	public static void main(String[] args) {
		Product p3 = new Product(3, "Java最強入門邁向頂尖高手之路：王者歸來(第二版)全彩版" //資料結構：使用Java
				, 1000, 8);
		System.out.println("id:"+p3.getId());//3
		System.out.println("name:"+p3.getName());//Java最強入門邁向頂尖高手之路：王者歸來(第二版)全彩版
		System.out.println("unitPrice:"+p3.getUnitPrice());//1000.0
		
		//double price = p3.getUnitPrice()+ 200;
		//p3.setUnitPrice(price);
		
		ProductServiceI service = new ProductServiceI();
		service.addPrice(p3.getUnitPrice());
		System.out.println("unitPrice:"+p3.getUnitPrice());//1000.0
		
		service.addPrice(p3);
		System.out.println("unitPrice:"+p3.getUnitPrice());//1200.0
	}
}

class ProductServiceI {
	public void addPrice(double price) {
		price = price +200;		
	}
	
	public void addPrice(Product p) {
		p.setUnitPrice(p.getUnitPrice()+200);		
	}
}