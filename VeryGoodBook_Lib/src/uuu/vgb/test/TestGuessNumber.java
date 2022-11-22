package uuu.vgb.test;

import java.util.Random;
import java.util.Scanner;

public class TestGuessNumber {
	public static void main(String[] args) {
		int max = 3; //最多猜3次
		int bound = 10; //猜1~10之間的數字
		
		Random randomGenerator = new Random();
		int answer = randomGenerator.nextInt(bound) + 1; //Math.random()*9+1;
		
		//System.out.print("答案:" + answer + ",");
		System.out.println("請猜一個1~"+bound+"之間的整數數字(最多可以猜" +max+ "次):");
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		//System.out.println("你猜的是: "+ input);
		int target = 0;
		if(input!=null && input.matches("\\d+")) {
			target = Integer.parseInt(input);
		}
		
		int counter = 1;
		while(target!=answer && counter<max) {
			if(target<1 || target>bound) { 
				System.out.println("猜的數字已超出範圍，遊戲強迫在此結束");
				break;
			}
			System.out.println("猜錯了，還有" + (max - counter++) + "次機會!");
			System.out.println("請再猜一個~"+bound+"之間的整數數字:");
			target = scanner.nextInt();		
			System.out.println("你猜的是: "+ target);
		}
		
		if(target==answer) {
			System.out.println("恭喜猜對了");
		}else {
			System.out.println("GG...! 答案:" + answer);
		}
	}
}
