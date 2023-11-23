

//	請定義一個常數為3.1415(圓周率)，並計算半徑為5的圓面積與圓周長

package hw1;

public class HW1_4 {
	public static void main(String[] args) {
		final double PI = 3.14;
		int r = 5;
		
		System.out.println( "圓面積 = "+(PI * r*r) );
		System.out.printf( "圓周長 = %.2f", (2 * PI *r));  // ％.2f 告訴printf 格式化輸出後方()內的值，並且顯示小數後兩位的數字。
	}
}
