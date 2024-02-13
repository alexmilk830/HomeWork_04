package hw9;

public class HW9_1 {
	public static void main(String[] args) {
		
		try {
		Eaters Moon = new Eaters("饅頭人");
		//將 Eaters 物件包裝成一個執行緒，以便於後續可以通過 moonThread 這個執行緒來執行 Eaters 物件中的程式邏輯。
		Thread moonThread = new Thread(Moon);
		
		Eaters james = new Eaters("詹姆士");
		Thread jamesThread = new Thread(james);
		

		System.out.println("-----大胃王快食比賽開始！------");
		
		moonThread.start();
		jamesThread.start();
		
		//主執行緒會等待 moonThread 和 jamesThread 這兩個執行緒執行結束，才繼續執行下一步
		moonThread.join();
		jamesThread.join();
		
		//下一步
		System.out.println("-----大胃王快食比賽結束！------");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}