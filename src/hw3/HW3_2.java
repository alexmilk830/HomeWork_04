package hw3;

import java.util.Scanner;

public class HW3_2 {
	public static void main(String[] args) {
		System.out.println("開始猜數字吧!");
		Scanner sc = new Scanner(System.in);
		int rdNum = (int)(Math.random()*10+1);
		while(true){
			int n = sc.nextInt();//需要在迴圈內部重新讀取新的猜測值，否則會無限檢查
			if(n != rdNum) {
			System.out.println("猜錯囉");
			}
			else{System.out.println("答對了！答案就是"+ n);
			break;
			}
		}
	sc.close();
	}
}
