package hw5;

import java.util.ArrayList;

public class HW5_5 {
	public static void main(String[] args) {

		getAuthCode();

	}

	public static void getAuthCode() {

		System.out.println("本次隨機產生的驗證碼為：");

		ArrayList<Character> list = new ArrayList<>();

		for (int i = 'A'; i <= 'Z'; i++) { // 取得A~Z的ASCII編碼
			char c = (char) i;
			list.add(c);
		}

		for (int i = 'a'; i <= 'z'; i++) {
			char c = (char) i;
			list.add(c);
		}

		for (int i = '0'; i <= 9; i++) {
			char c = (char) i;
			list.add(c);
		}

		for (int i = 0; i < 8; i++) { // 取8次
			int index = (int) (Math.random() * list.size()); // 隨機取出一個index的值
			System.out.print(list.get(index));

		}
	}
}
