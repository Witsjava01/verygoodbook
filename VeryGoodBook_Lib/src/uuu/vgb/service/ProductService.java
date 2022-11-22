package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBException;

public class ProductService {	
	private ProductsDAO dao = new ProductsDAO();
	
	public List<Product> getAllProducts() throws VGBException{
		List<Product> list = dao.selectAllProducts();		
		return list;
	}
	
	public List<Product> getProductsByName(String keyword) throws VGBException{
		if(keyword==null) {
			throw new IllegalArgumentException("用關鍵字查詢產品時必須輸入一個字以上的條件");
		}else if(keyword.length()==0) {
			return dao.selectAllProducts();
		}
		
		List<Product> list = dao.selectProductsByName(keyword);		
		return list;
	}
	
	public List<Product> getProductsByCategory(String category) throws VGBException{
		if(category==null || category.length()==0) {
			throw new IllegalArgumentException("用分類查詢產品時分類條件必須有值");
		}
		
		List<Product> list = dao.selectProductsByCategory(category);		
		return list;
	}
	
	public List<Product> getNewestProducts()throws VGBException{		
		
		List<Product> list = dao.selectNewestProducts();		
		return list;
	}
	
	public Product getProductById(String productId)throws VGBException{		
		if(productId==null || productId.length()==0) {
			throw new IllegalArgumentException("用產品代碼查詢產品時必須有代碼資料");
		}
		Product p = dao.selectProductById(productId);
//		if("xxx".equals(p.getCategory())) {
//			p = dao.
//		}
		return p;
	}
	
	public List<Size> getSizeList(String productId, String colorName)throws VGBException{
		if(productId==null || colorName==null) {
			throw new IllegalArgumentException("用產品代碼查詢Size時必須有代碼與colorName資料");
		}
		
		return dao.selectSizeList(productId, colorName);
	}
}