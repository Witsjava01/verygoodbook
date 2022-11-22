package uuu.vgb.test;

import uuu.vgb.entity.VIP;

public class TestVIP {

	public static void main(String[] args) {
		VIP vip = new VIP();
		vip.setId("A123456770");
		vip.setName("王武");
		vip.setPassword("asdf12");
		vip.setGender('M');
		vip.setBirthday(1990,12,31);
		vip.setEmail("test05@gmail.com.tw");
		vip.setDiscount(10);
		
		System.out.println(vip);
//		System.out.println("id:"+vip.getId());
//		System.out.println("name:"+vip.getName());
//		System.out.println("password:"+vip.getPassword());
//		System.out.println("gender:"+vip.getGender());
//		System.out.println("birthday:"+vip.getBirthday());
//				//+vip.getBirthday().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPAN));
//		System.out.println("email:"+vip.getEmail());
//		System.out.println("discount:" + vip.getDiscount() + "% off"); //10 
//		System.out.println("VIP折扣:" + vip.getDiscountString()); //9折
	}
}