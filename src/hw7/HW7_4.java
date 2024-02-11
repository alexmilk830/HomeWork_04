package hw7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class HW7_4 {
	public static void main(String[] args) {
		outputSer();
	}

	public static void outputSer() {
		ObjectOutputStream oos;
		Cat c1 = new Cat("小貓一號");
		Cat c2 = new Cat("小貓二號");
		Dog d1 = new Dog("花田一路");
		Dog d2 = new Dog("花田二路");
		ArrayList<Object> list = new ArrayList<>();
		Collections.addAll(list, c1,c2,d1,d2); //一次加入多個物件
		
		//取得目標檔案的父目錄，如果父目錄不存在，則使用 mkdirs() 方法創建一個名為data的Directory
		File dest =new File("/Users/alexmilk830/Documents/data/Object.ser"); 
		File parentDir = dest.getParentFile();
		if(!parentDir.exists()) {
			parentDir.mkdirs();
		}
		try {
			oos = new ObjectOutputStream(new FileOutputStream(dest));
			oos.writeObject(list);
			oos.close();
			System.out.println("序列化成功！");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
