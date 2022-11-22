package uuu.vgb.entity;

import java.time.LocalDate;
//import java.util.Date;
import java.time.Period;
import java.time.format.DateTimeParseException;

import uuu.vgb.exception.VGBDataInvalidException;

public class Customer {
	private String id; //必要, PKey, ROC Id
	private String password; //必要, 6~20個字元
	private String name; //必要, 2~20個字元
	private char gender; //必要, 'M':男, 'F':女, 'U':Unknown	
	private String email; //必要, unique index
	//public Date birthday; //需要import java.util.Date, JDK 7(含)以下的版本應使用這個類別
	private LocalDate birthday; //必要(須年滿12歲)，需要import java.time.LocalDate, JDK 8開始才有這個類別
	
	private String address="";//非必要, not null, 0~100個字元
	private String phone=new String(""); //非必要, not null, 0~30個字元
	private boolean subscribed;
	
	public Customer() {}
	
	public Customer(String id, String password, String name) {
		this.setId(id);
		this.setPassword(password);
		this.setName(name);
	}
	
	public Customer(String id, String password, String name, 
			char gender, String email, String birthday) {
//		super();
//		this.setId(id);
//		this.setPassword(password);
//		this.setName(name);
		this(id, password, name);		
		this.setGender(gender);
		this.setEmail(email);
		this.setBirthday(birthday);
	}

	private static final String idFirstCharSequence="ABCDEFGHJKLMNPQRSTUVXYWZIO";
	private static final String idPattern = "[A-Za-z][1289]\\d{8}";
	public static boolean checkROCId(String id) { //A123456789				
		if(id!=null && id.matches(idPattern)) {//用regular expression來檢查id的格式
			id = id.toUpperCase();			
			//加上第一碼A-Z轉換為數字			
			final char c1 = id.charAt(0);			
//			int n1 = idFirstCharSequence.indexOf(c1) + 10; //0;	//可以替代29-53
//			if(n1==9) return false; 
			
			int n1=0;
			if(c1>='A' && c1<='H') { //10-17
				n1=c1-'A'+10;
			}else if(c1>='J' && c1<='N') {//18-22
				n1=c1-'J' + 18;
			}else if(c1>='P' && c1<='V') {//23-29
				n1=c1-'P' + 23;
			}else{ //XYWZIO->30,31,32,33,34,35
				switch(c1) {
					case 'X':
						n1 = 30;break;
					case 'Y':
						n1 = 31;break;
					case 'W':
						n1 = 32;break;
					case 'Z':
						n1 = 33;break;
					case 'I':
						n1 = 34;break;
					case 'O':
						n1 = 35;break;	
					default:
						return false;
				}
			}
			
			//System.out.println("n1:" + n1); //for test			
			
			int sum = n1/10 + n1%10*9;			
			// 依公式加總  sum + n2*8 + + n3*7
			for(int i=8,j=1;i>0;i--,j++) {
				int n = id.charAt(j)-'0';
				//System.out.print(sum + "+" + n +"*" + i + "=" + sum+"+"+(n * i) + ":"); //for test
				sum += n*i; //sum = sum + n*i;
				//System.out.println(sum); //for test				
			}
			
//			sum = sum + (id.charAt(2)-'0') * 7;
//			sum = sum + (id.charAt(3)-'0') * 6;
//			sum = sum + (id.charAt(4)-'0') * 5;
//			sum = sum + (id.charAt(5)-'0') * 4;
//			sum = sum + (id.charAt(6)-'0') * 3;
//			sum = sum + (id.charAt(7)-'0') * 2;
//			sum = sum + (id.charAt(8)-'0') * 1;
//			System.out.print(sum + "+" + (id.charAt(9)-'0') + "=" ); //for test
			sum += (id.charAt(9)-'0') * 1; //sum = sum + (id.charAt(9)-'0') * 1;
//			System.out.println(sum); //for test
			return sum%10 == 0;
		}		
		return false;		
	}
	
	
	public String getId() {
		return this.id;
	}	
	
	public void setId(String id){		
		if(checkROCId(id)) {
			this.id = id.toUpperCase();
		}else {
			//System.err.println("身分證號不正確: " + id);
			throw new VGBDataInvalidException("身分證號不正確: " + id);
		}
	}
	
	
 	public String getPassword() {
		return this.password;
	}
	
 	public static final int MIN_PASSWORD_LENGTH = 6;
 	public static final int MAX_PASSWORD_LENGTH = 20;
	public void setPassword(String password) {
		if(password!=null && 
					password.length()>=MIN_PASSWORD_LENGTH && 
					password.length()<=MAX_PASSWORD_LENGTH) {
			this.password = password;
		}else {
			//第13章, 改成throw XXXException
			String msg = String.format("密碼必須%d~%d個字元，但您輸入的是 %s\n", 
					MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH, password);
			throw new VGBDataInvalidException(msg);
		}
	}
	
	
	
	public String getName() {
		return name;
	}

 	public static final int MIN_NAME_LENGTH = 2;
 	public static final int MAX_NAME_LENGTH = 20;
	public void setName(String name) {
		if(name!=null && 
				(name=name.trim()).length()>=2 && 
				 name.length()<=20) {
			this.name = name;
		}else{
			//第13章, 改成throw XXXException
			//System.err.println("客戶姓名必須2~20個字元:" + name);			
			String msg = String.format("客戶姓名必須%d~%d個字元，但您輸入的是:%s\n", 
					MIN_NAME_LENGTH, MAX_NAME_LENGTH, name);
			throw new VGBDataInvalidException(msg);
		}
	}


	public char getGender() {		
		return gender;
	}

	public static final char MALE='M';
	public static final char FEMALE='F';
	public static final char UNKNOWN='U';
	public void setGender(char gender) {
		if(gender==MALE || gender==FEMALE || gender==UNKNOWN) {
			this.gender = gender;
		}else {
			throw new VGBDataInvalidException("客戶性別資料輸入錯誤: " + gender);
		}
	}


	public LocalDate getBirthday() {
		return birthday;
	}
	
	public static final int MIN_AGE=12; //符合規則(須年滿12歲)
	public void setBirthday(LocalDate birthday) {//Encapsulate要的setter
		if(birthday==null) {
			//第13章，改成throw XXXException
			throw new IllegalArgumentException("客戶生日不得為null");
		}
		
		//檢查參數birthday符合規則(須年滿12歲)才指派給birthday屬性
		Period period = Period.between(birthday, LocalDate.now());
		int age = period.getYears();
		if(age>=MIN_AGE) {
			this.birthday = birthday;
		}else {
			//第13章，改成throw XXXException
			String msg = String.format("客戶生日必須年滿%d歲:%s", MIN_AGE, birthday);
			throw new VGBDataInvalidException(msg);
		}
	}
	
	/**
	 * 將year, month, day三個int參數轉換成LocalDate物件後，指派給birthday屬性
	 * @param year,month,day
	 */
	public void setBirthday(int year, int month, int day){
		//將year, month, day三個整數參數轉換成LocalDate物件
		try {
			LocalDate date = LocalDate.of(year, month, day); 
			
			//並呼叫this.setBirthday(date)來完成檢查與指派
			this.setBirthday(date);
		}catch(java.time.DateTimeException e) {
			throw new VGBDataInvalidException("客戶生日日期資料不正確: " + e.getMessage());
		}
	}
	
	/**
	 * 將dateStr字串參數轉換成LocalDate物件後，指派給birthday屬性
	 * @param dateStr: 生日日期字串，必須符合iso-8601日期(yyyy-MM-dd)
	 */
	public void setBirthday(String dateStr) {
		if(dateStr==null) this.setBirthday((LocalDate)null);
		
		//將dateStr字串參數轉換成LocalDate物件
		try {
			LocalDate date = LocalDate.parse(dateStr);
			
			//呼叫this.setBirthday(date)來完成檢查與指派
			this.setBirthday(date);
		}catch(DateTimeParseException e) {
			throw new VGBDataInvalidException("客戶生日日期格式應符合yyyy-MM-dd(如:2001-03-05)，但你輸入的是:" + dateStr);
		}
	}
		
	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}

	private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	public void setEmail(String email) { // ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
		if(email!=null && email.matches(EMAIL_PATTERN)) {
			this.email = email;
		}else {
			throw new VGBDataInvalidException("email格式不正確:" + email);
		}
	}

	public void setAddress(String address) {
		if(address==null) address="";		
		this.address = address.trim();
	}


	public String getPhone() {		
		return phone;
	}

	public void setPhone(String phone) {
		if(phone==null) phone="";		
		this.phone = phone;
	}	


	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
	
	/**
	 * 從客戶birthday屬性計算客戶年齡
	 * @return int型態的客戶年齡
	 */	 
	 public int getAge() {
		 return getAge(this.birthday);
	 }
	
	 /**
	  * 從參數birthday計算客戶年齡
	  * @return int型態的客戶年齡
	 */
	 private int getAge(LocalDate birthday) {
		if(birthday!=null) { //參數birthday有資料，才可以算年齡
			Period period = Period.between(birthday, LocalDate.now());
//			System.out.println(
//				period.getYears() + "年" 
//						+ period.getMonths()+"月" + period.getDays()+"天"); //for test
			int age = period.getYears();
//			if(period.getMonths()==6 && period.getDays()>0 
//				|| period.getMonths()>6) {
//				age=age+1;
//			}			
			return age;
		}else{ //birthday屬性是null就回傳-1，表示無法計算年齡
			//TODO: 第13章，改成throw XXXException
			throw new VGBDataInvalidException("客戶生日為null，無法計算年齡");
			//return -1;
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() 
			+ "\nid="+id + ",密碼="+password + ",姓名=" + name 
			+ "\n, 性別=" + gender + ",email=" + email 
			+ "\n, 生日=" + birthday + ", 年齡=" + (birthday!=null?getAge() + "歲":"無法計算年齡") 
			+ "\n, 地址=" + address 
			+ "\n, 電話=" + phone + ", 訂閱電子報=" + subscribed;
	}	
	Integer i ;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		}else if (!id.equals(other.id))
			return false;
		return true;
	}	 
	
}