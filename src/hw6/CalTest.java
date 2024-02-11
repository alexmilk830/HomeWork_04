package hw6;


	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class CalTest {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Calculator c = new Calculator();
			while (true) {
				try {
					System.out.println("請輸入x的值"); // (1.1 + enter鍵)
					int x = sc.nextInt();
					System.out.println("請輸入y的值");
					int y = sc.nextInt();
					System.out.println(x + "的" + y + "次方等於" + c.powerXY(x, y));
					break;
				} catch (CalException e) {

				} catch (InputMismatchException e) { 
					System.out.println("輸入格式不正確");
				    sc.nextLine(); //清空緩衝區，避免陷入無窮迴圈
				} 
			}
			sc.close();
		}
	}

