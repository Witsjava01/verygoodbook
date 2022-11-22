package uuu.vgb.test;

import java.time.LocalDate;
public class TestImmutable {
	public static void main(String[] args) {
		Integer i = 1;
		Integer j = i;
		System.out.println(i==j);
		i++;
		System.out.println(i);
		System.out.println(j);
		
		String s = "Hello ";
		String s1 = "Hello ";
		System.out.println(s==s1); //true
		System.out.println(s); //Hello
		System.out.println(s1); //Hello
		s = s+"World";
		System.out.println(s); //Hello WOrld
		System.out.println(s1); //Hello
		System.out.println(s.toUpperCase()); //HELLO WORLD
		System.out.println(s); //Hello WOrld
		
		int x = 1;
		int y = x;
		x++;
		System.out.println(x); //2
		System.out.println(y); //1	
		
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(today);
		System.out.println(tomorrow);
	}
}