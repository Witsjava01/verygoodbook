/*
truncate table vgb.products;
*/

SELECT name, unit_price, stock, photo_url, description, launch_date, category, discount FROM products;
INSERT INTO products 
	(id, name, unit_price, stock, photo_url,discount,category)
    VALUES(1,'Java學習手冊 第五版', 680,12,
		'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/37/0010923732.jpg&w=374&h=374&v=626bbe47'
        ,21,'書籍');

INSERT INTO products 
	(id, name, unit_price, stock, photo_url,discount,category)
    VALUES(2, '最新 Java 程式語言 修訂第七版', 680,8,
		'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/091/85/0010918576.jpg&w=374&h=374&v=62204450'
        ,5,'書籍');
        
INSERT INTO products
			/*(id, name, unit_price, stock, photo_url, description, launch_date, category, discount)*/
            VALUES(3, 'Java SE 17基礎必修課(適用Java 17~10，涵蓋ITS Java國際認證)', 560,9,
            'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/68/0010926843.jpg&v=629dd745k&w=348&h=348',
            '',
            '2022-08-01','書籍', 21);
            
INSERT INTO products
			(id, name, unit_price, stock, photo_url, description, launch_date, category, discount)
            VALUES(4, 'Java最強入門邁向頂尖高手之路：王者歸來(第二版)全彩版', 1000,11,
            'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/087/31/0010873110.jpg&w=374&h=374&v=5f7c475b',
            '',
            (curdate()),'書籍', 21),
            (5, '圖說演算法：使用Java', 490,9,
            'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/084/55/0010845577.jpg&w=187&h=187&v=5e0b2337',
            '',
            '2022-08-01','書籍', 10);
            
INSERT INTO products
			(id, name, unit_price, stock, photo_url, description, launch_date, category, discount)
            VALUES(11, '[MUJI無印良品]繪圖色鉛筆/12色(R)', 145,8,
            'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/100/24/N001002483.jpg&w=348&h=348&v=5d22e5b9',
            '',
            (curdate()),'文具', 0),
            (12, '[MUJI無印良品]水性繪筆',39,28,            
            'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277566.jpg&w=348&h=348&v=603f2e52k',
            '', (curdate()),'文具', 0);
INSERT INTO products
			(id, name, unit_price, stock, photo_url, description, launch_date, category, discount)
            VALUES(13, '【德國LYRA】Groove三角洞洞色鉛筆(10色)', 360,8,
            'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/007/38/N000073899.jpg&v=56137711k&w=348&h=348',
            '',
            (curdate()),'文具', 25),
            (14, '【德國LYRA】Groove三角洞洞鉛筆(6入)',360,28,            
            'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/142/82/N001428261.jpg&v=628b3961k&w=348&h=348',
            '', (curdate()),'文具', 20);            
            
INSERT INTO products 
	(id, name, unit_price, stock, photo_url,discount,category)
    VALUES(18,'Java學習手冊 第五版', 780,2,
		'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/091/08/0010910870.jpg&v=61af37eak&w=348&h=348'
        ,10,'書籍');
            