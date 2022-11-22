/* LEFT OUTER JOIN*/
/* E05:查詢指定代號的產品 */
SELECT id, product_colors.product_id, name, 
			product_colors.color_name, 
            product_color_sizes.color_name AS size_color,
            COUNT(size_name) AS size_count, 
        IFNULL(MIN(product_color_sizes.unit_price),products.unit_price) AS unit_price,
        IFNULL(SUM(product_color_sizes.stock),products.stock) AS stock,
        IFNULL(SUM(product_color_sizes.stock),product_colors.stock) AS color_stock,
        products.photo_url,
		description, launch_date, category, discount,
        product_colors.photo_url color_photo, 
        IFNULL(icon_url,product_colors.photo_url) icon_url
	FROM products
		LEFT JOIN product_colors ON products.id=product_colors.product_id
        LEFT JOIN product_color_sizes
			ON products.id=product_color_sizes.product_id
				AND (product_colors.color_name = product_color_sizes.color_name
					OR product_colors.color_name IS NULL)
        WHERE products.id = '17'
			GROUP BY products.id,product_colors.color_name
