package hw8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HW8_2 {
	public static void main(String[] args) {

		Train t1 = new Train(202, "普悠瑪", "樹林", "花蓮", 400);
		Train t2 = new Train(1254, "區間", "屏東", "基隆", 700);
		Train t3 = new Train(118, "自強", "高雄", "台北", 500);
		Train t4 = new Train(1288, "區間", "新竹", "基隆", 400);
		Train t5 = new Train(122, "自強", "台中", "花蓮", 600);
		Train t6 = new Train(1222, "區間", "樹林", "七堵", 300);
		Train t7 = new Train(1254, "區間", "屏東", "基隆", 700);
		noRepeat(t1, t2, t3, t4, t5, t6, t7);
		sort(t1, t2, t3, t4, t5, t6, t7);
		sortAndNoRepeat(t1, t2, t3, t4, t5, t6, t7);
	}

	//印出不重複的Train物件
	public static void noRepeat(Train t1, Train t2, Train t3, Train t4, Train t5, Train t6, Train t7) {
		HashSet<Object> hs = new HashSet<>(); //需要Override hashCode 和 equals方法，確定比較內容、定義哈希碼的給予方式
		Collections.addAll(hs, t1, t2, t3, t4, t5, t6, t7);

		Iterator<Object> it = hs.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}

	}
	//依照班次編號大小印出
	public static void sort(Train t1, Train t2, Train t3, Train t4, Train t5, Train t6, Train t7) {
		ArrayList<Train> list = new ArrayList<>();
		Collections.addAll(list, t1, t2, t3, t4, t5, t6, t7);
		
//使用一個 Lambda 表達式 (o1, o2) -> o2.getNumber() - o1.getNumber()，這個 Lambda 表達式定義了一個比較器，用來比較兩個 Train 物件的 number 屬性，排序的順序是降冪，即大的 number 排在前面。
		Collections.sort(list, (o1, o2) -> o2.getNumber() - o1.getNumber());
		
//創建了一個匿名的 Comparator 物件，實現了 compare 方法，該方法返回兩個 Train 物件 o1 和 o2 的 getNumber() 屬性的差值
//		Collections.sort(list, new Comparator<Train>() {
//		    @Override
//		    public int compare(Train o1, Train o2) {
//		        return o2.getNumber() - o1.getNumber();
//		    }
//		});

		
//		for (Train t : list) {
//			System.out.println(t);
//		}
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
	public static void sortAndNoRepeat(Train t1, Train t2, Train t3, Train t4, Train t5, Train t6, Train t7) {
		
		//創建一個比較器，這個比較器會使用 Train 物件的 getNumber 方法的返回值進行比較。comparingInt 表示期望比較的是整數，並使用 getNumber 方法的返回值進行比較。
		TreeSet<Train> ts = new TreeSet<>(Comparator.comparingInt(Train::getNumber));  
		//:: 是 Java 中的方法引用（Method Reference）語法。它是一種簡化 Lambda 表達式的語法形式，特別是在 Lambda 表達式中只包含一個方法調用的情況。
		//使用了 :: 來引用 Train 類別中的 getNumber 方法。這個方法引用相當於提供了一個可以被 Comparator 使用的比較函數。
	
		Collections.addAll(ts, t1,t2,t3,t4,t5,t6,t7);
		for (Train t : ts) {
			System.out.println(t);
		}
	}
}
