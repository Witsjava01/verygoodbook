SELECT * FROM vgb.customers;

UPDATE customers 
	SET name='李四方', password='asdf1234', gender='M', email='square.lee@gmail.com', birthday='2000-12-05',
		address='台中市西區臺灣大道二段309號2樓', phone='0987654666', subscribed=false
    WHERE id='A123123132';
    
UPDATE customers 
	SET name=?, password=?, gender=?, email=?, birthday=?,
		address=?, phone=?, subscribed=?
    WHERE id=?; 
    
UPDATE customers 
	SET password=?
    WHERE id=?;     