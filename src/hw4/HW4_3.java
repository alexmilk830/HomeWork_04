//有個字串陣列如下 (八大行星):
//{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)
//(提示:字元比對，String方法)

package hw4;



public class HW4_3 {
	public static void main(String[] args) {
		String []planets = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
		
		// 呼叫 countVowels 方法計算母音總數
		int vowelCount = countVowels(planets);
	        System.out.println("母音總數: " + vowelCount);
	    }
		
		//計算字串陣列中母音的總數（第一個字串+第二個字串+第三個字串...)
		public static int countVowels(String[] words) {
		    int count = 0;
		    for (int i = 0; i < words.length; i++) {
		        count += countVowelsInWord(words[i]);
		    }
		    return count;
		}
		
		// 方法：計算單個字串中母音的數量，如果是則將 vowelCount 變數加一
		 public static int countVowelsInWord(String word) {
		        int vowelCount = 0;
		        for (int i = 0; i < word.length(); i++) {
		            char currentChar = word.charAt(i); //把字串裡的字逐一檢查
		            if (isVowel(currentChar)) {
		                vowelCount++;
		            }
		        }
		        return vowelCount;
		    }
		
		// 使用 isVowel 方法判斷當前字元是否為母音
		    public static boolean isVowel(char c) {
		        c = Character.toLowerCase(c); //如果有大寫，先轉換成小寫字元
		        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
		    }
		
		//swtich 寫法
//	      public static boolean isVowel(char c) {
//		        c = Character.toLowerCase(c); // 轉換為小寫字母進行比較
//		        switch (c) {
//		            case 'a':
//		            case 'e':
//		            case 'i':
//		            case 'o':
//		            case 'u':
//		                return true; // 如果是元音字母，返回 true
//		            default:
//		                return false; // 如果不是元音字母，返回 false
//		        }
//		    }
		}

