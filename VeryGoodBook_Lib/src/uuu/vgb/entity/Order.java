package uuu.vgb.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private int id;
	private Customer member;
	private LocalDate createdDate;
	private LocalTime createdTime;	
	private int status; //0-新訂單,1-已付款,2-已入帳,3-已出貨,4-已到貨,5-已簽收,6-已完成
	
	private PaymentType paymentType;
	private double paymentFee;
	private String paymentNote; //非必要
	
	private ShippingType shippingType;
	private double shippingFee;
	private String shippingNote; //非必要
	
	private String recipientName;
	private String recipientEmail;
	private String recipientPhone;
	private String shippingAddress;
	
	private double totalAmount;
	
	private Set<OrderItem> orderItemsSet = new HashSet<>();
	
	//orderItemsSet's accessor(s)
	public Set<OrderItem> getOrderItemsSet() {
		return new HashSet<>(orderItemsSet); //回傳該集合物件的複本
	}
	
	public int size() {
		return orderItemsSet.size();
	}

	public boolean isEmpty() {
		return orderItemsSet.isEmpty();
	}

	public int getTotalQuantity() {
		int sum=0;
		for(OrderItem item:orderItemsSet) {
			sum+=item.getQuantity();
		}
		return sum;
	}

	//orderItemsSet's mutators
	public void add(OrderItem orderItem) { //for E11:查詢訂單明細 OrdersDAO讀取資料庫的訂單明細
		if(orderItem==null)
			throw new IllegalArgumentException("查詢訂單明細時orderItem不得為null");
		orderItemsSet.add(orderItem);
	}
	
	public void add(ShoppingCart cart) { //for E09:結帳 CheckoutServlet讀取session與request的FormData
		if(cart==null || cart.isEmpty()) {
			throw new IllegalArgumentException("結帳時購物車cart不得為空的");
		}
		if(cart.getMember()!=null) this.setMember(cart.getMember());
		for(CartItem cartItem:cart.getCartItemsSet()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setColor(cartItem.getColor());
			orderItem.setSizeName(cartItem.getSizeName());
			orderItem.setPrice(cart.getUnitPrice(cartItem));
			orderItem.setQuantity(cart.getQuantity(cartItem));
			orderItemsSet.add(orderItem);
		}		
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getMember() {
		return member;
	}
	public void setMember(Customer member) {
		this.member = member;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalTime createdTime) {
		this.createdTime = createdTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public double getPaymentFee() {
		return paymentFee;
	}
	public void setPaymentFee(double paymentFee) {
		this.paymentFee = paymentFee;
	}
	public String getPaymentNote() {
		return paymentNote;
	}
	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}
	public ShippingType getShippingType() {
		return shippingType;
	}
	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}
	public double getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getShippingNote() {
		return shippingNote;
	}
	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddres) {
		this.shippingAddress = shippingAddres;
	}
	
	public double getTotalAmount() {		
		if(orderItemsSet!=null && orderItemsSet.size()>0) {
			double sum = 0;
			
			for(OrderItem item:orderItemsSet) {
				sum += item.getPrice()* item.getQuantity();
			}
			return sum;
		}
		return totalAmount;
	}
	
	public double getTotalAmountWithFee() {
		return getTotalAmount() + paymentFee + shippingFee;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", member=" + member + ", 訂購日期時間=" + createdDate + " " + createdTime 
					+ ", 處理狀態=" + status 
				+ ",\n paymentType=" + paymentType + ", paymentFee=" + paymentFee + ", paymentNote=" + paymentNote 
				+ ",\n shippingType=" + shippingType + ", shippingFee=" + shippingFee + ", shippingNote=" + shippingNote 
				+ ",\n recipientName=" + recipientName + ", recipientEmail="
				+ recipientEmail + ", recipientPhone=" + recipientPhone + ", shippingAddress=" + shippingAddress
				+ ", totalAmount=" + totalAmount + ", orderItemsSet=" + orderItemsSet 
				+ ",\n 共" + size()  + "項, " + getTotalQuantity() + "件, 總金額" + getTotalAmount() 
				+ "元, 總金額+運費共" + getTotalAmountWithFee();
	}
	
	
	
}
