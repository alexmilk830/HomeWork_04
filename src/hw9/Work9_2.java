
package hw9;
//小吳老師版本範例答案
	class Account1 { 
		private int deposit = 0; // 存款餘額

		synchronized public void save(int i) // 匯款
		{
			String name = Thread.currentThread().getName();
			while (deposit > 3000) {
				System.out.println(name + "看到餘額超過3000，暫停匯款");
				try {
					wait();
				} catch (InterruptedException e) {
					// main方法呼叫媽媽執行緒的interrupt()，就是代表wait被中斷了，就會觸發此例外
					System.err.println("媽媽可以結束匯款惹～");
					// 結束該次方法執行
					return;
				}
				// 會從wait狀態醒過來並執行至此
				System.out.println(name + "被熊大要求匯款!");
			}
			deposit += i;
			System.out.println(name + "存了" + i + "，帳戶共有：" + deposit);
			notify();
		}

		synchronized public void withdraw(int i) // 提款
		{
			String name = Thread.currentThread().getName();
			while (deposit < i) {
				System.out.println(name + "看到帳戶沒錢，暫停提款");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 會從wait狀態醒過來並執行至此，代表被Mom執行緒notify
				System.out.println(name + "被老媽告知帳戶已經有錢!");
			}
			int sum = deposit;
			sum -= i;
			System.out.println(name + "領了" + i + "，帳戶共有：" + sum);
			deposit = sum;
			if (deposit <= 2000) {
				System.out.println(name + "看到餘額在2000以下，要求匯款");
				notify();
			}
		}
	}

	class Mom implements Runnable {
		private Account1 account;

		public Mom(Account1 account) {
			this.account = account;
		}

		public void run() {
			for (int i = 1; i <= 10; i++) {
				account.save(2000);
			}
		}
	}

	class Son implements Runnable {
		public static boolean isFinished = false;
		private Account1 account;

		public Son(Account1 account) {
			this.account = account;
		}

		public void run() {
			for (int i = 1; i <= 10; i++) {
				account.withdraw(1000);
			}
			// 代表熊大已結束
			isFinished = true;
		}
	}


public class Work9_2 {
	
	public static void main(String[] args) {
		Account1 account = new Account1(); //初始化帳戶
		Mom mom = new Mom(account);//建立物件
		Son son = new Son(account);
		Thread t_mom = new Thread(mom, "媽媽");//建立執行序
		Thread t_son = new Thread(son, "熊大");
		t_mom.start();
		t_son.start();
		
		while (true) {
			// 熊大執行緒跑完了而且媽媽還在就中斷wait
			if (Son.isFinished && t_mom.isAlive()) {
				t_mom.interrupt();
			}
			
			try {
				// 讓無窮迴圈睡一下，把執行權讓出來
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			// 兩個執行緒都結束了，main也可以結束
			if (Son.isFinished && !t_mom.isAlive())
				break;
		}
	}
}
