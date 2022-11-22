package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uuu.vgb.entity.Order;
import uuu.vgb.entity.OrderItem;
import uuu.vgb.exception.VGBException;
class OrdersDAO {
	
	private static final String INSERT_ORDERS="INSERT INTO orders\r\n"
			+ " (id, customer_id, created_date, created_time,\r\n"
			+ "		payment_type, payment_fee, shipping_type, shipping_fee, \r\n"
			+ "        recipient_name, recipient_email, recipient_phone, shipping_addres,"
			+ "		status)\r\n"
			+ "	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,0)";
	private static final String INSERT_ORDER_ITEMS="INSERT INTO order_items\r\n"
			+ "	(order_id, product_id, color_name, size_name, price, quantity)\r\n"
			+ "    VALUES(?,?,?,?,?,?)";
	void insert(Order order) throws VGBException {
		try(
				Connection connection = MySQLConnection.getConnection();//1,2 取得連線
				PreparedStatement pstmt1 = connection.prepareStatement(INSERT_ORDERS, Statement.RETURN_GENERATED_KEYS); //3.準備指令1
				PreparedStatement pstmt2 = connection.prepareStatement(INSERT_ORDER_ITEMS); //3.準備指令2
			) {
			
			//3.1 傳入pstmt1的?的值
			pstmt1.setInt(1, order.getId());
			pstmt1.setString(2, order.getMember().getId());
			pstmt1.setString(3, String.valueOf(order.getCreatedDate()));
			pstmt1.setString(4, String.valueOf(order.getCreatedTime()));
			pstmt1.setString(5, order.getPaymentType().name());
			pstmt1.setDouble(6, order.getPaymentType().getFee());
			pstmt1.setString(7, order.getShippingType().name());
			pstmt1.setDouble(8, order.getShippingType().getFee());
			pstmt1.setString(9, order.getRecipientName());
			pstmt1.setString(10, order.getRecipientEmail());
			pstmt1.setString(11, order.getRecipientPhone());
			pstmt1.setString(12, order.getShippingAddress());
			
			pstmt1.executeUpdate(); //4.執行pstmt1
			
			//5.讀取rs
			try(
				ResultSet rs = pstmt1.getGeneratedKeys();
			){
				while(rs.next()) {
					int orderId = rs.getInt(1);				
					order.setId(orderId);
				}
			}
			
			//3.2 傳入pstmt2的?的值
			for(OrderItem orderItem:order.getOrderItemsSet()) {
				pstmt2.setInt(1, order.getId());
				pstmt2.setInt(2, orderItem.getProduct().getId());
				pstmt2.setString(3, orderItem.getColorName());
				pstmt2.setString(4, orderItem.getSizeName());
				pstmt2.setDouble(5, orderItem.getPrice());
				pstmt2.setInt(6, orderItem.getQuantity());
				pstmt2.executeUpdate(); //4.執行pstmt2
			}
			
		} catch (SQLException e) {
			throw new VGBException("新增訂單失敗", e);
		}
	}

}
