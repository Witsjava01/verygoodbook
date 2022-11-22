/* 查出products所有資料 */
/* 2022-08-04: 12筆 */
SELECT id, name, unit_price, stock, photo_url, 
		description, launch_date, category, discount
	FROM products;

/* 查出product_colors所有資料 */    
/* 2022-08-04: 9筆(12-3, 14-1, 15-3. 16-2) */
SELECT product_id, color_name, stock,
		photo_url, icon_url FROM product_colors;

/* cross join(交叉連接) */
SELECT id, name, unit_price, products.stock, products.photo_url, 
		description, launch_date, category, discount,
        product_id, color_name, product_colors.photo_url AS color_photo, 
        icon_url, product_colors.stock AS color_stock
	FROM products
		CROSS JOIN product_colors;
        
/* inner join(內連接) */
SELECT id, name, unit_price, products.stock, products.photo_url, 
		description, launch_date, category, discount,
        product_id, color_name, product_colors.photo_url color_photo, 
        icon_url, product_colors.stock AS color_stock
	FROM products
		JOIN product_colors ON products.id=product_colors.product_id;        

/*inner join(內連接)不適合用在檢試產品明細*/
SELECT id, name, unit_price, products.stock, products.photo_url, 
		description, launch_date, category, discount,
        product_id, color_name, product_colors.photo_url color_photo, 
        icon_url, product_colors.stock AS color_stock
	FROM products
		INNER JOIN product_colors ON products.id=product_colors.product_id
        WHERE product_id IN (1,2,12,14,15,16,18);   

/* LEFT OUTER JOIN*/
/* E05:查詢指定代號的產品 */
SELECT id,product_id, color_name, 
		name, unit_price, products.stock, products.photo_url,
		description, launch_date, category, discount,
        product_colors.photo_url color_photo, 
        IFNULL(icon_url,product_colors.photo_url) icon_url, 
        product_colors.stock AS color_stock
	FROM products
		LEFT JOIN product_colors ON products.id=product_colors.product_id
        WHERE products.id = '12';   
        
/* RIGHT OUTER JOIN*/
SELECT id,product_id, color_name, name, unit_price, products.stock, products.photo_url, 
		description, launch_date, category, discount,
        product_id, color_name, product_colors.photo_url color_photo, 
        icon_url, product_colors.stock AS color_stock
	FROM products
		RIGHT JOIN product_colors ON products.id=product_colors.product_id
        /*WHERE product_colors.product_id = '1'*/;           