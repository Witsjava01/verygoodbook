package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerServiceUpdate {

	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		try {
			Customer c = service.login("A123456789", "12345;lkj");
			System.out.println(c);
			c.setName("狄慧桂");
			//c.setAddress("台北市復興北路101號4F");
			//c.setPassword("12345;lkj");
			service.update(c);
			
			c = service.login("A123456789", "12345;lkj");
			System.out.println(c);
		} catch (VGBDataInvalidException e) {
			Logger.getLogger("TestCustomerServiceUpdate").log(
					Level.SEVERE,e.getMessage());
		} catch (VGBException e) {
			Logger.getLogger("TestCustomerServiceUpdate").log(
					Level.SEVERE,e.getMessage(),e);
		}catch(Exception e) {
			Logger.getLogger("TestCustomerServiceUpdate").log(
					Level.SEVERE,"非預期錯誤",e);
		}

	}

}
