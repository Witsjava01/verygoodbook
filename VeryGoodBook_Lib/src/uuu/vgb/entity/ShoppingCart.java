package uuu.vgb.entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import uuu.vgb.exception.VGBDataInvalidException;

public class ShoppingCart {
	public static final NumberFormat PRICE_FORMAT = new DecimalFormat("######0.00");
	public static final NumberFormat AMOUNT_FORMAT = new DecimalFormat("########0");

	private Customer member;
	private Map<CartItem, Integer> cart = new HashMap<>();

	public Customer getMember() {
		return member;
	}

	public void setMember(Customer member) {
		this.member = member;
	}

	// cart's mutators: add, update, remove
	public void add(Product product, String colorName, Size size, int quantity) {
		if(product==null) {
			throw new IllegalArgumentException("加入購物車時Product物件不得為null");
		}
		
		if(quantity<=0) {
			throw new IllegalArgumentException("加入購物車時quantity必須>0");
		}
		
		Color color= null;
		if(product.isColorful() && colorName!=null) {
			color = product.findColor(colorName);
			if(color==null) {
				throw new VGBDataInvalidException(
						"加入購物車時顏色不符合產品的顏色清單:" + product.getId() +"-" + colorName);
			}
		} else if(product.isColorful() && (colorName==null || colorName.length()==0 )) {
			throw new VGBDataInvalidException("加入購物車時顏色不符合產品的顏色清單:" + colorName);
		}
		
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setColor(color);
		item.setSize(size);
		
		Integer oldQty = cart.get(item); //檢查cart中是否已經有這個購物明細
		if(oldQty!=null) { //若有則將現在數量+之前已經已有的數量
			quantity += oldQty;
		}
				
		cart.put(item, quantity);		
	}

	public void update(CartItem item, int quantity) {
		if (cart.get(item) != null) {
			cart.put(item, quantity);
		}
	}

	public Integer remove(CartItem item) {
		return cart.remove(item);
	}

	// cart's accessors
	// 1. from delegate methods
	public int size() {
		return cart.size();
	}

	public boolean isEmpty() {
		return cart.isEmpty();
	}

	public int getQuantity(CartItem key) {
		Integer qty = cart.get(key);
		return qty == null ? 0 : qty;
	}
	
	public double getUnitPrice(CartItem key) {
		if(!(key.getProduct() instanceof Outlet) && 
				member instanceof VIP) {
			return key.getListPrice() * (100-((VIP)member).getDiscount())/100;
		}
		
		return key.getUnitPrice();
	}
	
	public String getDiscountString(CartItem key) {
		if(!(key.getProduct() instanceof Outlet) && 
				member instanceof VIP) {
			return "VIP"+((VIP)member).getDiscountString();
		}
		
		return key.getDiscountString();
	}

//	public Set<CartItem> getCartItemsSet(Comparator<CartItem> comparator) {
//		TreeSet<CartItem> set = new TreeSet<>(comparator);
//		set.addAll(cart.keySet());		
//		return set; //回傳set的複本
//	}

	public Set<CartItem> getCartItemsSet() {
		// return cart.keySet();
		// //不要回傳set的正本，會造成cart.remove(item)發生java.util.ConcurrentModificationException

		return new HashSet<>(cart.keySet()); // 回傳set的複本

		// 注意下列回傳樣式要在CartItem類別實作Comparable介面並override compareTo方法
		// return new TreeSet<>(cart.keySet()); //回傳依加入時間排序的set複本
	}

	// 2. business methods
	/**
	 * 計算該筆明細(item)的小計金額
	 * 
	 * @param item
	 * @return
	 */
	public double getAmount(CartItem item) {
		int qty = this.getQuantity(item);
		double amount = this.getUnitPrice(item) * qty;
		return amount;
	}
	
	public double getListAmount(CartItem item) {
		int qty = this.getQuantity(item);
		double amount = item.getListPrice() * qty;
		return amount;
	}

	/**
	 * 計算cart中產品總購買數量
	 * 
	 * @return
	 */
	public int getTotalQuantity() {
		int sum = 0;
		for (Integer qty : cart.values()) {
			if (qty != null)
				sum += qty;
		}
		return sum;
	}

	/**
	 * 計算cart中產品原訂價總金額
	 * 
	 * @return
	 */
	public double getTotalListAmount() {
		double sum = 0;
		for (CartItem item : cart.keySet()) {
			sum += this.getListAmount(item);
		}
		return sum;
	}
	
	/**
	 * 計算cart中產品總金額
	 * 
	 * @return
	 */
	public double getTotalAmount() {
		double sum = 0;
		for (CartItem item : cart.keySet()) {
			sum += this.getAmount(item);
		}
		return sum;
	}

	@Override
	public String toString() {
		String cartItemContent = "";
		for (CartItem item : getCartItemsSet()) {
			cartItemContent += item + ", 數量:" + getQuantity(item) + ", 小計:" + getAmount(item) + "\n";
		}

		return "購物車[會員=" + (member != null ? member.getName() : "") + ", 購物明細:\n" + cartItemContent + ",\n 共" + size()
				+ "項, " + getTotalQuantity() + "件, 總金額=" + getTotalAmount() + "元";
	}
}