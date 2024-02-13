package hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class HW8_1 {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<>();
		Collections.addAll(list, new Integer(100), new Double(3.14), new Long(21L), new Short("100"), new Double(5.1),
				"Kitty", new Integer(100), new Object(), "Snoopy", new BigInteger("1000"));
		printAll(list); //印出list物件裡所有的元素
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Object next = it.next();
			if (!(next instanceof Number)) {
				it.remove();
			}
		}
		System.out.println("=======移除Number相關物件後剩餘的元素========");
		printAll(list);

	}

	public static void printAll(ArrayList<Object> list) {
		// iterator 遍歷
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
		System.out.println("-------------------");
		// for 遍歷
		for (int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("-------------------");
		// forEach() 遍歷
		for (Object o : list) {
			System.out.println(o);
		}

	}
}
