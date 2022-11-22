SELECT id, password, name, gender, email, birthday, 
	address, phone, subscribed, discount FROM customers;
    
/* 模擬 用帳號密碼登入*/	
SELECT id, password, name, gender, email, birthday, 
	address, phone, subscribed, discount FROM customers 
    WHERE id='a123123123' AND password='\'OR\'\'=\''; 
    
/* 模擬 用(帳號或email)和密碼登入*/	    
SELECT id, password, name, gender, email, birthday, 
	address, phone, subscribed, discount FROM customers 
    WHERE (id='A123123123' or email='A123123123' )  AND password='\'OR\'\'=\'';     
    
/* 模擬 用(帳號或email)查詢 0~1個客戶*/                 /*  \'OR\'\'=\'    */    
SELECT id, password, name, gender, email, birthday, 
	address, phone, subscribed, discount FROM customers 
    WHERE id='test123@uuu.com.tw' or email='test123@uuu.com.tw'; 