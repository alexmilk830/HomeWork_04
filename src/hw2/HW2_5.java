

//阿文很熱衷大樂透 (1 ~ 49)，但他不喜歡有4的數字，不論是個位數或是十位數。請設計一隻程式， 輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
package hw2;

public class HW2_5 {
	public static void main(String[] args) {
		
		int count = 0;
		for (int a=1;a<50;a++) {
			if(a%10==4 || (a/10) == 4) {	
			continue;
			}
		System.out.print( a + " ");
		count++;
		}
		System.out.println();
		System.out.print("總共有" + count + "個選擇");
		
		
	

	}
}