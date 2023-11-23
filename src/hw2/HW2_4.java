

//請設計一隻Java程式，輸出結果為以下:
//1 4 9 16 25 36 49 64 81 100
package hw2;

public class HW2_4 {
	public static void main(String[] args) {
		int power=1;
		while(power<=10) {
			int square = power * power;
			System.out.print(square + " ");
			power++;
		
		}
	
	}
}
