DROP VIEW IF EXISTS products_list_view;
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = root@localhost 
    SQL SECURITY DEFINER
VIEW products_list_view AS
    SELECT 
        products.id,products.name,product_colors.color_name,        
        IFNULL(MIN(product_color_sizes.unit_price),products.unit_price) AS unit_price,
        MIN(product_color_sizes.unit_price) AS min_size_price,
        MAX(product_color_sizes.unit_price) AS max_size_price,
        IFNULL(IFNULL(SUM(product_color_sizes.stock),SUM(product_colors.stock)),products.stock) AS stock,
        IFNULL(product_colors.photo_url,products.photo_url) AS photo_url,
        products.category AS category, 
        products.launch_date AS launch_date,
        products.discount AS discount
    FROM
        ((products
        LEFT JOIN product_colors ON ((products.id = product_colors.product_id)))
        LEFT JOIN product_color_sizes ON (((products.id = product_color_sizes.product_id)
            AND ((product_colors.color_name = product_color_sizes.color_name)
            OR (product_colors.color_name IS NULL)))))
    GROUP BY products.id