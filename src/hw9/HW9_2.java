package hw9;

public class HW9_2 {
	public static void main(String[] args) {
		Mom mom = new Mom();
		BrownWithdraw brownWithdraw = new BrownWithdraw(mom, 1000);
		MomDeposit momDeposit = new MomDeposit(mom, 2000);
		
		brownWithdraw.start();
		momDeposit.start();
	}

}