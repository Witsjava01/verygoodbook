package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.ShoppingCart;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;

public class TestShoppingCart {

	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		ProductService pService = new ProductService();
		try {
			Customer member = cService.login("A123456789", "asdf1234");
			Product p1 = pService.getProductById("1");
			//System.out.println(p1); //for test
			
			ShoppingCart cart = new ShoppingCart();
			cart.setMember(member);
			cart.add(p1, null, null, 1);
			//System.out.println(cart);
			
			Product p12 = pService.getProductById("12");
			//System.out.println(p12); //for test
			
			cart.add(p12, "紅", null, 1);
			cart.add(p12, "芥黃", null, 1);
			cart.add(p1, null, null, 1);
			//System.out.println(cart);
			
			cart.add(p12, "紅", null, 1);
			
			Product p16 = pService.getProductById("16");
			{
				String color = "薄荷綠";
				String size = "S";
				Size sizeObj = null;
				if(p16.getSizeCount()>0 && size!=null) {
					List<Size> sizeList= pService.getSizeList("16", color);
					for(Size theSize:sizeList) {
						if(size.equals(theSize.getSizeName())) {
							sizeObj = theSize;
							break;
						}
					}
					if(sizeObj==null) System.out.println("加入購物車時此產品查無該尺寸:" + p16.getId() + "-" + color + "-" + size);	 
				}
				//System.out.println(p16); //for test			
				cart.add(p16, color, sizeObj, 1);
			}
			{
				String color = "薄荷綠";
				String size = "L";
				Size sizeObj = null;
				if(p16.getSizeCount()>0 && size!=null) {
					List<Size> sizeList= pService.getSizeList("16", color);
					for(Size theSize:sizeList) {
						if(size.equals(theSize.getSizeName())) {
							sizeObj = theSize;
							break;
						}
					}
					if(sizeObj==null) System.out.println("加入購物車時此產品查無該尺寸:" + p16.getId() + "-" + color + "-" + size);	 
				}
				cart.add(p16, color, sizeObj, 2);
			}
			System.out.println(cart);			
		} catch (VGBException|VGBDataInvalidException e) {
			Logger.getLogger("測試購物車").log(Level.SEVERE, e.getMessage(), e);
		} catch(Exception e) {
			Logger.getLogger("測試購物車").log(Level.SEVERE, "發生非預期錯誤", e);
		}
				

	}

}
