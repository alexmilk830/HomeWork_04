

//	某人在銀行存入150萬，銀行利率為2%，如果每年利息都繼續存入銀行，請用程式計算10年後，本金加利息共有多少錢 
//離散複利的公式 A=P(1+r)^t	A是最終本利和、P是初始本金、r是利率、t是年數。

package hw1;

public class HW1_5 {
	public static void main(String[] args) {
		double P = 1500000, r = 0.02, t = 10;
		double A = P * (Math.pow(1+r, t)); // A=P(1+r)^t
		System.out.printf("%.0f元", A); 
	}
}
