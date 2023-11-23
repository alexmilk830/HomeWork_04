

//	由程式算出256559秒為多少天、多少小時、多少分與多少秒。
//	1天 = 24*60*60秒
//  一小時 = 60*60秒
//	一分鐘 = 60秒

package hw1;

public class HW1_3 {
	public static void main(String[] args) {

		int totalSeconds = 256559;
		System.out.println(totalSeconds/(24*60*60) + "天"); 
		System.out.println((totalSeconds%(24*60*60))/(60*60) + "小時" ); 
		System.out.println( (totalSeconds%(24*60*60))%(60*60)/60+ "分鐘"); 
		System.out.println( (totalSeconds%(24*60*60))%(60*60)%60+ "秒"); 
		
//如果用迴圈解的話：
//		int totalSeconds = 256559;
//	 	int[] units = { 24 * 3600, 3600, 60, 1 };
//		String[] unitNames = { "天", "小時", "分", "秒" };
//
//      for (int i = 0; i < units.length; i++) {
//      int currentUnitValue = totalSeconds / units[i];
//      totalSeconds %= units[i];  //第二圈會等於第一圈的餘數除array的第二項，第三圈等於第二圈的餘數除array的第三項，循環往復
//      System.out.println(currentUnitValue + unitNames[i]);
//      }
	}
}

