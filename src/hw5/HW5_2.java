package hw5;

public class HW5_2 {
	public static void main(String[] args) {
		
		randAvg();
		 
	}
	
	public static void randAvg() {
		int[] numbers = new int[10];
		int sum = 0;
		System.out.println("本次亂數結果：");
		for (int i=0;i<10;i++) {
			numbers [i] = (int)(Math.random()*101);
			sum += numbers[i];
			System.out.print(numbers[i]+ " ");
		}
		System.out.print("\n"+sum/10);
	}
}
