package hw9;

import java.io.PrintWriter;

public class HW9_2 {  //死結問題尚未解決，可參考小吳老師的範例答案 Work9_2


	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true); // true代表緩衝區的數據會在每次調用println、printf、format方法時自動刷新，確保輸出的即時性
		Account account = new Account(out); //account物件裡有balance(私有變數)，可以供不同執行緒共享
		BrownWithdrawThread brownWithdrawThread = new BrownWithdrawThread(account, 1000);
		MomDepositThread momDepositThread = new MomDepositThread(account, 2000);

		brownWithdrawThread.start();
		momDepositThread.start();

		try {
			brownWithdrawThread.join();
			momDepositThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		out.println(" 親子關係過期，帳戶存款目前剩餘 " + account.getBalance());

	}
	
}

class Account { //由兩個執行緒共享

	private int balance = 1000; // 初始帳戶金額

	PrintWriter out;

	// 建立Account物件時，即初始化PrinterWriter，以便在deposit()內即可使用out.println();
	Account(PrintWriter out) {
		this.out = out;
	}

	// 匯款方法
	void deposit(int amount) {
		while (getBalance() > 3000) { //每當使用deposit()方法時，先拿取最新的Account物件最新的balance金額，並判斷是否>3000
			out.println("媽媽看到餘額在3000以上，暫停匯款");
			try {
				wait(); // 如果帳戶高於匯款標準，則進入等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			out.println("熊大被媽媽告知帳戶已經有錢！");
		}
		
		int newBalance = getBalance() + amount;
		setBalance(newBalance);
		out.println("媽媽存了" + amount + "，帳戶共有：" + newBalance);
		if (newBalance > 3000) {
			out.println("熊大被媽媽告知帳戶已經有錢！");
			notifyAll();
		}
	}

	// 提款方法
	 void withdraw(int amount) {
		
		while (getBalance() < 2000) { //每次都取得最新的Balance
			out.println("熊大看到餘額在2000以下，要求匯款");
			try {
				wait(); // 餘額低於熊大提款標準，進入等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("媽媽被熊大要求匯款！");
		}
		
		out.println("有人在嗎2？");
		int newBalance = getBalance() - amount;
		setBalance(newBalance);
		out.println("熊大領了" + amount + "，帳戶共有：" + newBalance);

		if (newBalance < 2000) {
			out.println("媽媽被熊大要求匯款！");
			notifyAll();
		}
	}

	// 取得存款資訊
	int getBalance() {
		// simulate the delay in getting balance remotely
		return this.balance; // 回傳最新的帳戶餘額
	}

	// 更改存款金額
	void setBalance(int balance) {
		// simulate the delay in setting new balance remotely
		this.balance = balance;
	}
}

//媽媽匯款執行緒
class MomDepositThread extends Thread {
	Account account;
	int depositAmount;
	String name;

	MomDepositThread(Account account, int amount) { // 初始化DepositThread時，建立Account物件，並在run()裡使用Account物件的deposit()方法
		this.account = account;
		this.depositAmount = amount;
	}

	public void run() {// 在run()裡獲取DepositThread建構子初始化的實體變數，並執行deposit方法
		for (int i = 1; i <= 10; i++) {
			synchronized (account) {
				account.deposit(depositAmount);
			}
		}
		System.out.println("MomDepositThread end~");
	}

}

//熊大提款執行序
class BrownWithdrawThread extends Thread {
	Account account; 
	int depositAmount;

	BrownWithdrawThread(Account account, int amount) { // 初始化DepositThread時，建立Account物件，並在run()裡使用Account物件的deposit()方法
		this.account = account;
		this.depositAmount = amount;
	}

	public void run() { // 在run()裡獲取DepositThread建構子初始化的實體變數，並執行deposit方法
		for (int i = 1; i <= 10; i++) {
			synchronized (account) {
				account.withdraw(depositAmount);
			}
		}
		System.out.println("BrownWithdrawThread end~");
	}

}


 