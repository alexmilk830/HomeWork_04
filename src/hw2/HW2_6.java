

//請設計一隻Java程式，輸出結果為以下:
//12345678910
//123456789
//12345678
//1234567 
//123456 
//12345
//1234 
//123 
//12
//1
package hw2;

public class HW2_6 {
	public static void main(String[] args) {
		for (int i=10;i>0;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
