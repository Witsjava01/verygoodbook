package uuu.vgb.test;

public class TestAssignment {
	public static void main(String[] args) {
		int totalQuantity;
		totalQuantity = 030;
		System.out.println(totalQuantity);//24

		final byte quantityPlus = 1;		
		totalQuantity = quantityPlus; //promotion
		System.out.println(totalQuantity); //1
		
		double price = 12 * .8;
		System.out.println(price);
		System.out.println(Math.floor(price));
		
		int outPrice = (int)price; //casting, 等同於無條件捨去
		//outPrice = Math.floor(price); //試著將這行程式uncomment，並讓他可以執行
		System.out.println(outPrice);
				
		byte byteData = 77; 
		short shortData = byteData; //promotion		
		System.out.println(byteData); //77
		System.out.println(shortData); //77
		
		char gender = (char)byteData; //強迫casting, 0~65535
		System.out.println(byteData); //77是M的字碼
		System.out.println(Integer.toBinaryString(byteData)); //-77
		System.out.println(gender);   //M
		
		//char -> int 
		int intData = gender;
		System.out.println((int)gender);   //M的字碼: 77
		
		char charData = '1';
		intData = charData; //promotion
		System.out.println("charData: " + charData); //字元1
		System.out.println("intData: " + intData);   //字元1的字碼: 49
		
		//char '1' -> int 1
		System.out.println("intData: " + (intData-'0'));
		
		//測試 +=
		byte a=1,b=1,c=1,d=1;
		a += b+c/d; // a =   (byte)(a +(b+c/d))
		System.out.println(a); //3
		
		a = 1;
		a =  (byte)(a + (b+c/d));
		System.out.println(a); //3
		
		byte k=1;		
		k += 3/4f*2.5; // k = (byte)(k+(3/4f*2.5))
		System.out.println(k);
		String name = "John";
		String s = "Hello ";
		s += name + "!";
		System.out.println(s);
	}
}
