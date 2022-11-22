SELECT * FROM Customers;

INSERT INTO customers
	(id,name, password, gender, email, birthday,address, phone, subscribed)
	VALUES('A123456798','王武','567889', 'M', '55555@test.com','2000-05-02',
    '台北市信義區信義路五段100號1F','',false);
    
 /*DELETE FROM customers WHERE password='567889';*/
    
INSERT INTO customers
	(id,name, password, gender, email, birthday,
		address, phone, subscribed)
	VALUES(?,?,?,?,?,?,?,?,?);    