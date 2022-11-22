package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Size;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService_getSizeList {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		try {
			List<Size> list = pService.getSizeList("19", "白");
			System.out.println(list);
		} catch (VGBException e) {
			Logger.getLogger("測試sizeList").log(Level.SEVERE,
					e.getMessage(), e);
		} catch (Exception e) {
			Logger.getLogger("測試sizeList").log(Level.SEVERE,
					"發生非預期錯誤", e);
		}
	}
}
