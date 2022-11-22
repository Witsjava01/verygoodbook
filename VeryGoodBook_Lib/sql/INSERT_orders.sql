INSERT INTO orders
	(id, customer_id, created_date, created_time,
		payment_type, payment_fee, shipping_type, shipping_fee, 
        recipient_name, recipient_email, recipient_phone, shipping_addres,status)
	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,0);
    
INSERT INTO order_items
	(order_id, product_id, color_name, size_name, price, quantity)
    VALUES(?,?,?,?,?,?);