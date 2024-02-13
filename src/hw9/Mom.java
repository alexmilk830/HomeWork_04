package hw9;

public class Mom {
	private int account = 0; //私有變數，表示帳戶餘額。


	
	//定義存款規則與方法
	synchronized public void deposit(int amount) {
		while(account > 3000) {
			System.out.println("媽媽看到餘額在3000以上，暫停匯款");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		account += amount;
		System.out.println("媽媽存了" + amount  + "，帳戶共有：" + account);
		
		if (account > 3000) {
			System.out.println("熊大被媽媽告知帳戶已經有錢！");
			notify();
		}
		
	}
	//定義提款規則與方法
	synchronized public void withdraw(int amount) {
		while(account < amount) {
			System.out.println("熊大看到餘額在2000以下，要求匯款");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		account -= amount;
		System.out.println("熊大領了" + amount + "，帳戶共有：" + account);
		if (account < 2000) {
			System.out.println("媽媽被熊大要求匯款！");
			notify();
		}
	}
}

//BrownWithdraw執行序
class BrownWithdraw extends Thread {
	private Mom mom;
	private int withdrawAmount;
	
	public BrownWithdraw(Mom mom, int withdrawAmount) {
		this.mom = mom;
		this.withdrawAmount = withdrawAmount;
	}
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			mom.withdraw(withdrawAmount);
		}
			
	} 
}	

//MomDeposit執行序
class MomDeposit extends Thread {	
	private Mom mom;
	private int depositAmount;
	
	public MomDeposit(Mom mom, int depositAmount) {
		this.mom = mom;
		this.depositAmount = depositAmount;
	}
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			mom.deposit(depositAmount);
		}
	}
}

	

	
	
	
	