package uuu.vgb.entity;


public class VIP extends Customer{
	/**
	 * 紀錄VIP優惠折扣
	 */
	private int discount=5; //0, 1-90% off, 預設5% off

	public VIP() {
		//super();
	}

	public VIP(String id, String password, String name) {
		super(id, password, name);
	}

	public VIP(String id, String password, String name, 
			char gender, String email, String birthday) {
		super(id, password, name, gender, email, birthday);
	}

	/**
	 * @return int的VIP優惠折扣 
	 */
	public int getDiscount() {		
		return discount;
	}

	/**
	 * 設定VIP優惠折扣, 預設5% off
	 * @param discount 1-90% off
	 */
	public void setDiscount(int discount) {
		if (discount>0 && discount<=90) {
			this.discount = discount;
		} else {
			System.err.println("VIP discount必須1-90之間");
		}		
	}

	/**
	 * @return String型態的VIP優惠折扣,如5% off->95折
	 */
	public String getDiscountString(){
        int discount = 100 - this.discount;
        if(discount % 10 == 0){
            discount = discount / 10;
        }
        return discount + "折";
    }
	
	@Override
	public String toString() {
		return super.toString() 
			+ "\nVIP折扣=" + discount + "% off, " 
			+ getDiscountString();										
			
	}
}
