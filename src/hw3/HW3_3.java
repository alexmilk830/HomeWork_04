package hw3;

import java.util.Scanner;

public class HW3_3 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("阿文...請輸入你討厭哪個數字？");
		int n = sc.nextInt();
		int count=0;
		
		for(int a = 1;a<50;a++) {
			if(a%10==n || a/10==n) {
			continue;
			}
			System.out.print(a+"\t");
			count++;
			if(count%6==0) {
			System.out.print('\n');
			}
		}
	
	sc.close();
	System.out.print("總共有"+count+"數字可選");
	}
}
