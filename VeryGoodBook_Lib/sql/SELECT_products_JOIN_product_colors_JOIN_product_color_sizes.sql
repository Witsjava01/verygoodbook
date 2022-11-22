/* 查出products所有資料 */
/* 2022-08-11: 16筆: 1~7、18書籍, 11~17、19文具 */
SELECT id, name, unit_price, stock, photo_url, 
	description, launch_date, category, discount FROM products;

/* 查出product_colors所有資料 */    
/* 2022-08-11: 11筆(12-3, 14-1, 15-3, 16-2, 19-2) */
SELECT product_id, color_name, stock,
		photo_url, icon_url FROM product_colors;
        
/* 查出product_color_sizes所有資料 */    
/* 2022-08-11: 8筆(17--2, 19-白-4[XS,S,M,L], 19-黑-2[S,L]) */
SELECT product_id, color_name, size_name, stock, unit_price, ordinal 
	FROM product_color_sizes ORDER BY product_id, color_name, ordinal;        
    
/* 查詢全部產品與color, size明細 */
SELECT id, name, products.unit_price, 
	product_colors.color_name, product_color_sizes.color_name AS size_color, size_name,
    product_color_sizes.unit_price AS size_price,
	products.stock AS p_stock, product_colors.stock AS c_stock,
    product_color_sizes.stock AS size_stock,
	/*products.photo_url, product_colors.photo_url,*/    
    IFNULL(product_colors.photo_url, products.photo_url) AS photo_url,    
    category, discount
	FROM products 
		LEFT JOIN product_colors 
			ON products.id=product_colors.product_id
		LEFT JOIN product_color_sizes 
			ON products.id=product_color_sizes.product_id	
				AND (product_colors.color_name=product_color_sizes.color_name                
					OR product_colors.color_name IS NULL);

/* 查詢全部產品(color_stock, size_sotck) */	
    SELECT id, name, products.unit_price, 
	product_colors.color_name, product_color_sizes.color_name AS size_color, size_name,
    product_color_sizes.unit_price AS size_price,
    MIN(product_color_sizes.unit_price) AS min_size_price,	
    MAX(product_color_sizes.unit_price) AS max_size_price,	
	/*products.stock AS p_stock, product_colors.stock AS c_stock,product_color_sizes.stock AS size_stock,*/
    IFNULL(IFNULL(SUM(product_color_sizes.stock),SUM(product_colors.stock)), products.stock) AS stock, /* 庫存 */
	/*products.photo_url, product_colors.photo_url,*/    
    IFNULL(product_colors.photo_url, products.photo_url) AS photo_url,    
    category, discount
	FROM products 
		LEFT JOIN product_colors 
			ON products.id=product_colors.product_id
		LEFT JOIN product_color_sizes 
			ON products.id=product_color_sizes.product_id	
				AND (product_colors.color_name=product_color_sizes.color_name /*有顏色, 有尺寸*/            
					OR product_colors.color_name IS NULL)/*無顏色, 有尺寸*/
	GROUP BY products.id ;
    
/* 正式版: 查詢全部產品((size_sotck, color_stock, product_stock), (min_size_unit_price, unit_price)) */
SELECT id, name, products.unit_price,
	product_colors.color_name, product_color_sizes.color_name AS size_color, size_name,
    IFNULL(MIN(product_color_sizes.unit_price),products.unit_price) AS unit_price, 
    MIN(product_color_sizes.unit_price) AS min_size_price,	
    MAX(product_color_sizes.unit_price) AS max_size_price,	
    IFNULL(IFNULL(SUM(product_color_sizes.stock),SUM(product_colors.stock)), products.stock) AS stock, /* 庫存 */	
    IFNULL(product_colors.photo_url, products.photo_url) AS photo_url,    
    category, discount
	FROM products 
		LEFT JOIN product_colors ON products.id=product_colors.product_id
		LEFT JOIN product_color_sizes 
			ON products.id=product_color_sizes.product_id	
				AND (product_colors.color_name=product_color_sizes.color_name                
						OR product_colors.color_name IS NULL) 
	GROUP BY products.id;
    
/* 查詢指定產品代號與顏色的sizeList  */    
SELECT product_id, color_name, size_name, 
	product_color_sizes.stock, 
    IFNULL(product_color_sizes.unit_price, products.unit_price) AS list_price, 
    IFNULL(product_color_sizes.unit_price, products.unit_price) * (100-discount)/100 AS price,
    ordinal, discount
	FROM product_color_sizes
		INNER JOIN products ON product_color_sizes.product_id = products.id			
    WHERE product_id="19" AND color_name="白" ORDER BY ordinal;