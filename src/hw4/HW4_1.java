//有個一維陣列如下:
//{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
// 請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//(提示:陣列，length屬性)


package hw4;

public class HW4_1 {
	public static void main(String[] args) {
		int [] x = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
		double sum = 0;
		for(int i =0;i<x.length ;i++) {
			sum += x[i];	
		}
		double avg =sum/x.length;
		System.out.println("平均值=" + avg);
		
		System.out.print("大於平均值的元素：");
		for(int j=0;j<x.length;j++) {
			if(x[j]<=avg) {
				continue;
			}
			System.out.print(x[j]+ " ");
		}
	}
}
