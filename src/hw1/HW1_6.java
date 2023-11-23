

//請寫一隻程式，利用System.out.println()印出以下三個運算式結果: 5+5
//5 + ‘5’
//5 + “5”
// 並請用註解各別說明答案的產生原因
package hw1;

public class HW1_6 {
	public static void main(String[] args) {
		System.out.println(5+5); 		//	此為型態 int 整數相加
		System.out.println(5 + '5');	//	此為型態 int 和 char的相加， '5'的unicode是'\u0035'
										//		，0035透過十六進制轉換成十進制則為53，所以印出值 = 5 + 53 = 58
		System.out.println(5 + "5");	//	此為型態 int 和 string的串接 = (數字)5 + （字串）5 = 55 

	
	}
}

