USE vgb;

SELECT id, name, unit_price, stock, photo_url, description, launch_date, category, discount
	FROM products;
    
/* 查詢全部產品 */
SELECT id, name, unit_price, stock, photo_url, category, discount
	FROM products_list_view;

/* 依分類查詢產品 */    
SELECT id, name, unit_price, stock, photo_url, category, discount
	FROM products_list_view
    WHERE category="文具";

/* 依部分名稱查詢產品 */       
SELECT id, name, unit_price, stock, photo_url, category, discount
	FROM products_list_view
    WHERE name LIKE "%鉛筆%";
    
/* 查詢最新產品 */ 
SELECT id, name, unit_price, stock, photo_url, category, discount,launch_date
	FROM products_list_view
    WHERE launch_date<=curdate()    
    ORDER BY launch_date DESC, id DESC LIMIT 10;

/* 查詢指定代號的產品 */     
SELECT id, name, unit_price, stock, photo_url, 
		description, launch_date, category, discount
	FROM products_list_view
    WHERE id='2';
    
SELECT distinct category FROM products_list_view;
