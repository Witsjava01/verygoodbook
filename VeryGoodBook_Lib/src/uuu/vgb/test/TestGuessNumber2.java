package uuu.vgb.test;

import java.util.Random;
import java.util.Scanner;

public class TestGuessNumber2 {

	public static void main(String[] args) {
		int max = 5; //最多猜max次
		int bound = 50; //猜1~bound之間的數字
		
		Random randomGenerator = new Random();
		int answer = randomGenerator.nextInt(bound) + 1; //Math.random()*9+1;
		System.out.println("answer:" + answer); //for test
		
		Scanner scanner = new Scanner(System.in);
		int target = 0; //user猜的數字記錄在此
		int counter = 0; //user猜的次數記錄在此
		do {
			System.out.println("請猜一個1~"+bound+"之間的整數數字"
					+ "，還有" + (max - counter++) + "次機會:");
			target = scanner.nextInt();
			
			if(target<1 || target>bound) {
				System.out.println("猜的數字已超出範圍，遊戲強迫在此結束");
				break;
			}else if(target==answer) {
				System.out.println("恭喜猜對了");
				return;
			}			
		}while(target!=answer && counter<max);
		
		System.out.println("GG...! 答案:" + answer);
	}
}