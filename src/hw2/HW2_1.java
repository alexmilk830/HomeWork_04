

//請設計一隻Java程式，計算1~1000的偶數和 (2+4+6+8+...+1000)


package hw2;

public class HW2_1 {
	public static void main(String[] args) {
		
		int sum = 0;
		for(int c=1;c<=1000;c++) {
			
			if(c%2 == 0) {	
				sum += c;
			}
		}
		
		System.out.print(sum);
	}
}
