package uuu.vgb.service;

import uuu.vgb.entity.Order;
import uuu.vgb.exception.VGBException;

public class OrderService {
	private OrdersDAO dao = new OrdersDAO();
	public void createOrder(Order order) throws VGBException{
		if(order==null) {
			throw new IllegalArgumentException("建立訂單時order物件不得為null");
		}
		dao.insert(order);
	}
}
