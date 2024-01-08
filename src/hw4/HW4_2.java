	//請建立一個字串，經過程式執行後，輸入結果是反過來的
	//例如String s = “Hello World”
	//執行結果即為dlroW olleH (提示:String方法，陣列)
	
	package hw4;
	
	public class HW4_2 {
		public static void main(String[] args) {
			String s = "Hello World";
			char []x = new char[s.length()];
			for (int i=0; i<x.length;i++) {
				x[i]=s.charAt(i);
			}
			
			for(int j=x.length-1;j>=0;j--) {
				System.out.print(x[j]);
			}
		}
	}
