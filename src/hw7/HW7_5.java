package hw7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class HW7_5 {
	public static void main(String[] args) {
		inputSer();
	}

	public static void inputSer() {
		File src = new File("/Users/alexmilk830/Documents/data/Object.ser");
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(src));
			ArrayList<Object> list = (ArrayList<Object>) ois.readObject();
			for (Object obj : list) {
				if (obj instanceof Cat) {
					((Cat) obj).speak();
				} else if (obj instanceof Dog) {
					((Dog) obj).speak();
				}
			}
			System.out.println("序列化讀取完畢！");
			ois.close();
		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
}
