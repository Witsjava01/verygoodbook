package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerServiceRegister {
	public static void main(String[] args) {
		Customer c = new Customer();
		try {
			c.setId("A123456761");
			c.setName("李四方");
			c.setPassword("12345;lkj");
			c.setGender('M');
			c.setBirthday(2000,12,5);
			c.setEmail("test666@uuu.com.tw");
			
			c.setAddress("台北市");
			c.setPhone("0987654666");
			c.setSubscribed(true);
			
			CustomerService service = new CustomerService();		
			service.register(c);
			
		} catch (VGBException e) {
			Logger.getLogger("TestCustomerServiceRegister").log(
					Level.SEVERE, e.getMessage(),e); //for admin, tester, developer
		}catch(VGBDataInvalidException e) {
			System.err.println(e.getMessage()); //for user
		} catch (Exception e) {
			Logger.getLogger("TestCustomerServiceRegister").log(
					Level.SEVERE, "發生非預期錯誤",e); //for admin, tester, developer
		}
		
	}
}
