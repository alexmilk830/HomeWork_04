package hw7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HW7_1 {

	public static void main(String[] args) {
		File src = new File("Sample.txt");
		System.out.println("共有" + getCharCount(src) + "個字元");
		System.out.println("共有" + getByteCount(src) + "個位元組");
		System.out.println("共有" + getLineCount(src) + "列資料");
//		String currentWorkingDirectory = System.getProperty("user.dir");
//		System.out.println("當前工作目錄：" + currentWorkingDirectory);
//		String filePath = "example.txt";
//		Path path = Paths.get(filePath);
//		System.out.println(path);
		
	}

	
	
	public static int getLineCount(File src) {
		BufferedReader bf;
		String ch;
		int count = 0;
		try {
			bf = new BufferedReader(new FileReader(src));
			while ((ch = bf.readLine()) != null) { //readLine:讀取資料到換行符號為止
				count++;
//				System.out.println(ch);
			}
			bf.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return count;
	}
	
//設定每次讀取的陣列長度，優化讀取
//	public static int getLineCount(File src) {
//	    try (BufferedReader reader = new BufferedReader(new FileReader(src))) {
//	        int count = 0;
//	        char[] buffer = new char[1024]; //一次讀取1024個字元，提升效能
//	        while (reader.read(buffer) != -1) { //把read讀取的資料放入buffer陣列中
//	        	//在每次迴圈中，你遍歷 buffer 中的每個字符，並檢查是否為換行符 \n。如果是，則表示找到了一行，將行數 count 增加。
//	            for (char c : buffer) { 
//	                if (c == '\n') {
//	                    count++;
//	                }
//	            }
//	        }
//	        return count;
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	    return 0;
//	}


	//用FileInputStream讀取位元組
	public static int getByteCount(File src) {
	    try (FileInputStream fis = new FileInputStream(src)) {
	        byte[] buffer = new byte[1024];
	        int count = 0;
	        int totalCount = 0;
	        while ((count = fis.read(buffer)) != -1) {  //從 FileInputStream 一次讀取 buffer.length （1024個位元組），並將它們存入 buffer陣列 中。read 方法返回每次實際讀取的位元組數目。
	            totalCount += count; //每次都+1024個，直到最後一次<=1024個累加完
	        }
	        return totalCount;
	    } catch (IOException ie) {
	        ie.printStackTrace();
	    }
	    return 0;
	}

//用FileReader讀取字元
	public static int getCharCount(File src) {

		FileReader fr;
		int len;
		int count = 0;
		try {
			fr = new FileReader(src);
			while ((len = fr.read()) != -1) { //一次讀一個字元
				count++;
			}
			fr.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return count;
	}
}
