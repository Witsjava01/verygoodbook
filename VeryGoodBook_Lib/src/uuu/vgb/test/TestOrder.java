package uuu.vgb.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.ShippingType;
import uuu.vgb.entity.ShoppingCart;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;

public class TestOrder {

	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		ProductService pService = new ProductService();
		try {
			Customer member = cService.login("A223456781", "'or''='"); //15% off
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
			
			Product p19 = pService.getProductById("19");
			{
				String color = "白";
				String size = "M";
				Size sizeObj = null;
				if(p19.getSizeCount()>0 && size!=null) {
					List<Size> sizeList= pService.getSizeList("19", color);
					for(Size theSize:sizeList) {
						if(size.equals(theSize.getSizeName())) {
							sizeObj = theSize;
							break;
						}
					}
					if(sizeObj==null) System.out.println("加入購物車時此產品查無該尺寸:" + p19.getId() + "-" + color + "-" + size);
					System.out.println("*****size:"+sizeObj);
				}
				cart.add(p19, color, sizeObj, 2);
			}
			System.out.println(cart);		
			
			Order order = new Order();
			order.add(cart);
			order.setCreatedDate(LocalDate.now());
			order.setCreatedTime(LocalTime.now());
			order.setPaymentType(PaymentType.HOME);
			order.setPaymentFee(PaymentType.HOME.getFee());
			order.setShippingType(ShippingType.HOME);
			order.setShippingFee(ShippingType.HOME.getFee());
			
			order.setRecipientName(member.getName());
			order.setRecipientEmail(member.getEmail());
			order.setRecipientPhone(member.getPhone());
			order.setShippingAddress(member.getAddress());
			System.out.println(order);
			
			//oSerice.createOrder(order);
		} catch (VGBException|VGBDataInvalidException e) {
			Logger.getLogger("測試購物車").log(Level.SEVERE, e.getMessage(), e);
		} catch(Exception e) {
			Logger.getLogger("測試購物車").log(Level.SEVERE, "發生非預期錯誤", e);
		}
				

	}

}
