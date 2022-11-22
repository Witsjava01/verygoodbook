package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerLoginAgain{

	public static void main(String[] args) {
		//1.輸入
		String id = "A123123123";
		String password = "'or''='";
		
		//2.呼叫商業邏輯
		CustomerService service = new CustomerService();		
		try {
			Customer c = service.login(id, password);
			//3.1 輸出成功訊息
			System.out.println(c+"\n登入成功!");
		} catch (VGBException e) {
			//3.2 輸出錯誤訊息
			Logger.getLogger("TestCustomerLoginAgain").log(
					Level.SEVERE, e.getMessage(), e);		
		} catch(Exception e) {
			Logger.getLogger("TestCustomerLoginAgain").log(
					Level.SEVERE, "發生非預期錯誤", e);
		}
		
		System.out.println("The End");
	}
}
