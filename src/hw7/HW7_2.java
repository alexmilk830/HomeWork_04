package hw7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class HW7_2 {
	public static void main(String[] args) {
		getNumbers();
	}
	public static void getNumbers() {
		HashSet<Integer> hs = new HashSet<>();
		while (hs.size() < 10) {
			int num = (int) ((Math.random() * 1000) + 1);
			hs.add(num);
		}
		File dest = new File("./Data.txt"); 
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(dest, true)); //使用 PrintWriter 將生成的隨機數字寫入到 Data.txt 檔案中。這裡使用了 FileWriter 的建構子的第二個參數 true，表示在檔案末尾添加而不是覆蓋原有的內容。
			for (int s : hs) { // For-Each迴圈
				pw.printf("%d ",s); //將整數 s 格式化為字符串，然後將這個字符串寫入到檔案中，並在每個整數後面加上一個空格(%d後面有一個space)。這樣的格式化輸出使得檔案中的數字更易讀，並以空格分隔。
			}
			pw.println(); //讓每次Run的資料都換新的一行
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("亂數產生成功！");
	}
}
