package hw9;

public class Eaters implements Runnable{
	private String name;
	private static final int MIN_SLEEP_TIME = 500;
	private static final int MAX_SLEEP_TIME = 2500;
	
	public Eaters(String name) {
		this.name = name;
	}
	
	public void run() {
		try {
			for(int i = 1; i <= 10; i++) {
				eatRice(i);
				Thread.sleep(getRandomSleepTime());
			} 
		System.out.println(name + "吃完了！");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void eatRice(int round) {
		System.out.println(name + "吃第" + round + "碗飯");
	}
	
	private int getRandomSleepTime() {
		return  (int) (Math.random()*MAX_SLEEP_TIME) + MIN_SLEEP_TIME; //靜態方法不用先創建(new)物件，再呼叫方法
//		return new Random().nextInt(MAX_SLEEP_TIME) + MIN_SLEEP_TIME;
	}

}