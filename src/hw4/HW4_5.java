//請設計由鍵盤輸入三個整數，分別代表西元yyyy年，mm月，dd日，執行後會顯示是該年的第幾天
//例:輸入 1984 9 8 三個號碼後，程式會顯示「輸入的日期為該年第252天」
//(提示1:Scanner，陣列)
//(提示2:需將閏年條件加入) (提示3:擋下錯誤輸入:例如月份輸入為2，則日期不該超過29)

//
package hw4;

import java.util.Scanner;

public class HW4_5 {
	public static void main(String[] args) {
		getDayOfYear();
	}

	// 閏年規則： 1.能被4整除但不能被100整除的年份是閏年（例如2008、2012等）。
	// 或 2.能被400整除的年份也是閏年（例如2000年）。
	//
	public static void getDayOfYear() {
		Scanner sc = new Scanner(System.in);

		int[] leapYear = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] normalYear = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int dayOfYear = 0;
		int year, month, day;

		System.out.println("請輸入年:");
		year = sc.nextInt();
		System.out.println("請輸入月:");
		month = sc.nextInt();
		System.out.println("請輸入日:");
		day = sc.nextInt();

		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			// 閏年
			for (int i = 0; i < month; i++) {
				dayOfYear += leapYear[i]; // 將已經過月份的日期加總
			}
		} else {
			// 不是閏年
			for (int i = 0; i < month; i++) {
				dayOfYear += normalYear[i];
			}
		}

		if (day <= 0 || day >    (  (  (year % 4 == 0)  && (year % 100 != 0)  ) || (year % 400 == 0)   ? leapYear[month] : normalYear[month])) {
			//日期 < 0 或 日期 > 月份的天數
			// day > (condition ? leapYear[month] : normalYear[month]) 
			// condition =  year % 4 == 0 && year % 100 != 0 || year % 400 == 0 判斷是閏年還是普通年
			System.out.println("請輸入正確的日期");
		} else {
			dayOfYear += day;
			System.out.println("輸入的該日期為該年第" + dayOfYear + "天");
		}
		sc.close();
	}
}
