package hw4;

import java.util.Scanner;

public class HW4_4 {
	public static void main(String[] args) {
		System.out.println("借錢要還幹嘛借?想借多少?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //建立輸入的值
		
		int [][] x = {
				{25,2500},
				{32,800},
				{8,500},
				{19,1000},
				{27,1200},
		};
		System.out.print("員工編號：");
		int count = 0;
		for(int i=0;i<x.length;i++) {
			for(int j=1;j<x[i].length;j++) {
				
				if(n<=x[i][j]) {
					count ++;
					System.out.print(x[i][0]+" ");
				}
			}
		}
		System.out.print("共"+count+"人!");
		
	sc.close();
	}
	
	
}
