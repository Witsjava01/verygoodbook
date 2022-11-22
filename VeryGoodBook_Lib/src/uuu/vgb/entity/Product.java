package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Product extends Object{	
	private int id; //PKey, AutoIncrement, 0,1~
	private String name; //必要, 1~50個字元	
	private double unitPrice; //定價又是售價  必要, >0
	private int stock; //必要, >=0
	private String photoUrl; //非必要
	private String description=""; //非必要
	private LocalDate launchDate; //必要	
	private String category=""; //非必要	
	
	private int sizeCount; //computed column;	
	
	public int getSizeCount() {
		return sizeCount;
	}

	public void setSizeCount(int sizeCount) {
		this.sizeCount = sizeCount;
	}

	private Map<String,Color> colorsMap = null;
	
	//setter 改成 mutaters: add
	public void addColor(Color color) {
		if(color==null || color.getColorName()==null) 
			throw new IllegalArgumentException("加入顏色時，color物件不得為null");
		if(colorsMap==null) {
			colorsMap = new TreeMap<>();
		}
		colorsMap.put(color.getColorName(), color);
	}
	
	//getter 改成 accessor
	public Map<String, Color> getColorsMap() {
		if(isColorful()) {
			//作法1: 回傳不得變更的集合
			//return  Collections.unmodifiableMap(colorsMap);
			
			//作法2: 回傳該集合的複本
			return new TreeMap<>(colorsMap);
		}
		
		return null;		
	}
	
	public boolean isColorful() {
		return colorsMap!=null && colorsMap.size()>0;
	}
	
	public Color findColor(String colorName) {
		Color color = colorsMap.get(colorName);		
		return color;
	}
	
	public Product() {}


	public Product(int id, String name, double unitPrice) {		
		this.setId(id);
		this.setName(name);
		this.setUnitPrice(unitPrice);
	}

	public Product(int id, String name, double unitPrice, int stock) {
		this(id, name, unitPrice);
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得定價(也是售價)
	 * @return unitPrice屬性
	 */
	public double getUnitPrice() {//取得定價(也是售價)
		return unitPrice;
	}

	/**
	 * 設定定價(也是售價)
	 * @param unitPrice 指派給 unitPrice屬性
	 */
	public void setUnitPrice(double unitPrice) {//設定定價(也是售價)
		this.unitPrice = unitPrice;
	}

	public int getStock() {
		if(isColorful()) {
			Collection<Color> colors = colorsMap.values(); //import java.util.Collection
			int sum=0;

//			Iterator<Color> iterator = colors.iterator();
//			while(iterator.hasNext()) {
//				Color color = iterator.next();
//				sum += color.getStock();
//			}			
			
			for(Color color:colors) {
				sum += color.getStock();
			}
			
			return sum;
		}
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {//標準setter
		if(launchDate!=null) {
			this.launchDate = launchDate;
		}else{
			//TODO: 第13章 改成throw XXXException
			System.err.println("產品上架日期不得為null");
		}
	}
	
	public void setLaunchDate(String launchDate) {
		 	if(launchDate==null) {
		 		this.setLaunchDate((LocalDate)null);
		 		return;
		 	}
			LocalDate date = LocalDate.parse(launchDate);
			this.setLaunchDate(date);
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return  getClass().getName()
			+ ", 代號:" + id 
			+ ", 名稱:" + name 
			+ "\n, 單價=" + unitPrice 
			+ ", 庫存=" + getStock()
			+ "\n, 圖片url=" + photoUrl 
			+ "\n, 說明=" + description 
			+ "\n, 發售日=" + launchDate 
			+ ", 分類=" + category 
			+ ", 有下列顏色:  " + colorsMap	
			+ ", 有" + sizeCount + "個size"	;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass()!=obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
