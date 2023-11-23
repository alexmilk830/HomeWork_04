

////請設計一隻Java程式，計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
package hw2;

public class HW2_2 {
	public static void main(String[] args) {
		
		int tenFactorial = 1;
		for(int i = 1;i<=10; i++ ) {
			tenFactorial *= i; 
		}
		System.out.print(tenFactorial);
	}
}
