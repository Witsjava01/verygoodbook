package uuu.vgb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Color;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBException;

import java.sql.*;

class ProductsDAO {

	//private static final String SELECT_ALL_PRODUCTS=
//			"SELECT id, name, unit_price, stock, photo_url, category, discount"
//			+ "	FROM products";
	private static final String SELECT_ALL_PRODUCTS=
			"SELECT id, name, unit_price, stock, photo_url, category, discount"
			+ "	FROM products_list_view";
	List<Product> selectAllProducts() throws VGBException{
		List<Product> list = new ArrayList<Product>();		
		
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PRODUCTS);				
			){			
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
				//5. 處理rs
				while(rs.next()) {
					Product p;
					int discount = rs.getInt("discount");
					if(discount>0) {
						p = new Outlet();
						((Outlet)p).setDiscount(discount);
					}else {
						p = new Product();
					}
					
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("查詢全部產品失敗", e);
		}
		return list;
	}
	
//	private static final String SELECT_PRODUCTS_BY_NAME=
//			"SELECT id, name, unit_price, stock, photo_url, category, discount"
//			+ "	FROM products "
//			+ "    WHERE name LIKE ?";
	private static final String SELECT_PRODUCTS_BY_NAME=
			"SELECT id, name, unit_price, stock, photo_url, category, discount"
			+ "	FROM products_list_view "
			+ "    WHERE name LIKE ?";
	List<Product> selectProductsByName(String keyword) throws VGBException{
		List<Product> list = new ArrayList<Product>();		
		
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_NAME);				
			){
			//3.1傳入?的值
			pstmt.setString(1, '%'+keyword+'%');
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
				//5. 處理rs
				while(rs.next()) {
					Product p;
					int discount = rs.getInt("discount");
					if(discount>0) {
						p = new Outlet();
						((Outlet)p).setDiscount(discount);
					}else p = new Product();
								
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("用關鍵字查詢產品失敗:" + keyword, e);
		}		
		return list;
	}

//	private static final String SELECT_PRODUCTS_BY_CATEGORY =
//			"SELECT id, name, unit_price, stock, photo_url, category, discount"
//			+ "	FROM products"
//			+ "    WHERE category=?";
	private static final String SELECT_PRODUCTS_BY_CATEGORY =
			"SELECT id, name, unit_price, stock, photo_url, category, discount"
			+ "	FROM products_list_view"
			+ "    WHERE category=?";
	
	List<Product> selectProductsByCategory(String category) throws VGBException{
		List<Product> list = new ArrayList<Product>();		
		
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);				
			){
			//3.1傳入?的值
			pstmt.setString(1, category);
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
				//5. 處理rs
				while(rs.next()) {
					Product p;
					int discount = rs.getInt("discount");
					if(discount>0) {
						p = new Outlet();
						((Outlet)p).setDiscount(discount);
					}else p = new Product();
								
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("用分類查詢產品失敗:" + category, e);
		}		
		return list;
	}
	
	private static final String SELECT_NEWEST_PRODUCTS=
			"SELECT id, name, unit_price, stock, photo_url, category, discount,launch_date "
			+ "	FROM products_list_view "
			+ "    WHERE launch_date<=DATE_ADD(curdate(), INTERVAL 1 DAY)"
			+ "    ORDER BY launch_date DESC, id DESC LIMIT 10";
	List<Product> selectNewestProducts() throws VGBException{
		List<Product> list = new ArrayList<Product>();		
		
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_NEWEST_PRODUCTS);				
			){			
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
				//5. 處理rs
				while(rs.next()) {
					Product p;
					int discount = rs.getInt("discount");
					if(discount>0) {
						p = new Outlet();
						((Outlet)p).setDiscount(discount);
					}else {
						p = new Product();
					}
					
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));		
					p.setLaunchDate(rs.getString("launch_date"));
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("查詢最新產品失敗", e);
		}
		return list;
	}
	
//	private static final String select_Product_By_Id = "SELECT id, name, unit_price, stock, photo_url,"
//			+ "		description, launch_date, category, discount"
//			+ " FROM products" 
//			+ "    WHERE id=?";
	
//	private static final String select_Product_By_Id = 
//			"SELECT id,product_id, color_name,"
//			+ "		name, unit_price, products.stock, products.photo_url,"
//			+ "		description, launch_date, category, discount,"
//			+ "        product_colors.photo_url color_photo,"
//			+ "        IFNULL(icon_url,product_colors.photo_url) icon_url,"
//			+ "        product_colors.stock AS color_stock"
//			+ "	FROM products"
//			+ "		LEFT JOIN product_colors ON products.id=product_colors.product_id"
//			+ "        WHERE products.id =?";
	
	private static final String select_Product_By_Id = "SELECT id, product_id, name, color_name, size_color,"
			+ "     size_count, unit_price,"
			+ "		stock, color_stock, photo_url, description, launch_date, category, discount,"
			+ "		color_photo, icon_url FROM product_detail_view"
			+ "        WHERE id=?";
	Product selectProductById(String productId) throws VGBException{
		Product p = null;		
		try (	Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(select_Product_By_Id);//3.準備指令				
			){
			//3.1 傳入?的值
			pstmt.setString(1, productId);
			
			try(ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
				//5.處理rs
				while(rs.next()) {
					if(p==null) {
						int discount = rs.getInt("discount");
						if(discount>0) {
							p = new Outlet();
							((Outlet)p).setDiscount(discount);
						}else p = new Product();					
						
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("name"));
						p.setUnitPrice(rs.getDouble("unit_price"));
						p.setStock(rs.getInt("stock"));
						p.setPhotoUrl(rs.getString("photo_url"));
						p.setDescription(rs.getString("description"));
						p.setLaunchDate(rs.getString("launch_date"));
						p.setCategory(rs.getString("category"));		
						p.setLaunchDate(rs.getString("launch_date"));
						p.setSizeCount(rs.getInt("size_count"));
						//Logger.getLogger("顯示讀到的產品").log(Level.INFO, String.valueOf(p)); //for test
					}					
					
					//讀取顏色
					String colorName = rs.getString("color_name");
					if(colorName!=null) {
						Color color = new Color();
						color.setColorName(colorName);
						color.setStock(rs.getInt("color_stock"));
						color.setPhotoUrl(rs.getString("color_photo"));
						color.setIconUrl(rs.getString("icon_url"));
						
						p.addColor(color);
					}
				}
			}			
		} catch (SQLException e) {
			throw new VGBException("用代號查詢產品失敗",e);
		}		
		return p;
	}
	
	private static final String SELECT_SIZE_LIST="SELECT product_id, color_name, size_name, "
			+ "	product_color_sizes.stock, "
			+ "    product_color_sizes.unit_price AS list_price,"
			+ "    product_color_sizes.unit_price * (100-discount)/100 AS price,"
			+ "    ordinal, discount"
			+ "	FROM product_color_sizes"
			+ "		INNER JOIN products ON product_color_sizes.product_id = products.id"
			+ "    WHERE product_id=? AND color_name=? ORDER BY ordinal";
	
	List<Size> selectSizeList(String productId, String colorName)throws VGBException {
		List<Size> sizeList = new ArrayList<>();		
		try (   Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_SIZE_LIST); //3.準備指令
				){
			//3.1 傳入?的值
			pstmt.setString(1, productId);
			pstmt.setString(2, colorName);
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
				//5.處理rs
				while(rs.next()) {
					Size size = new Size();					
					size.setColorName(rs.getString("color_name"));
					size.setSizeName(rs.getString("size_name"));
					size.setStock(rs.getInt("stock"));
					size.setListPrice(rs.getDouble("list_price"));
					size.setUnitPrice(rs.getDouble("price"));
					size.setOrdinal(rs.getInt("ordinal"));
					
					sizeList.add(size);
				}				
			}
		} catch (SQLException e) {
			throw new VGBException("查詢sizeList失敗", e);
		}
		return sizeList;
	}
}
