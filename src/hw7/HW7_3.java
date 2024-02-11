package hw7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HW7_3 {
	public static void main(String[] args) {
		File src = new File("./Data.txt");
		File dest = new File("./b.txt");
		copyFile(src, dest);
	}
	public static void copyFile(File src, File dest) {
		FileInputStream fis;
		FileOutputStream fos;
		int len;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			while ((len = fis.read()) != -1) {
				fos.write(len);
			}
			fos.close();
			fis.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		System.out.println("複製成功！");
	}
}
