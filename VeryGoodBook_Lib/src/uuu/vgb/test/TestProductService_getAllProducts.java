package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Product;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService_getAllProducts {
	public static void main(String[] args) {
		ProductService service = new ProductService();
		try {
//			List<Product> list = service.getAllProducts();
//			System.out.println(list);
//			System.out.println("共"+list.size()+"筆");
			
//			List<Product> list2 = service.getProductsByName("圓規");
//			System.out.println(list2);
//			System.out.println("共"+list2.size()+"筆");
			
//			List<Product> list3 = service.getProductsByCategory("文具");
//			System.out.println(list3);
//			System.out.println("共"+list3.size()+"筆");
			
			List<Product> list4 = service.getNewestProducts();
			System.out.println(list4);
			System.out.println("共"+list4.size()+"筆");
		} catch (VGBException e) {
			Logger.getLogger("TestProductService_getAllProducts").log(
					Level.SEVERE,e.getMessage(), e);
		}
		

	}
}
