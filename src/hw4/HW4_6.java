package hw4;

public class HW4_6 {
  public static void main(String[] args) {
	  int [][] exam = { 
		
			{10, 35, 40, 100, 90, 85, 75, 70},
			{37, 75, 77, 89, 64, 75, 70, 95},
			{100, 70, 79, 90, 75, 70, 79, 90},
			{77, 95, 70, 89, 60, 75, 85, 89},
			{98, 70, 89, 90, 75, 90, 89, 90},
			{90, 80, 100, 75, 50, 20, 99, 75},
	 };
	int[] student = new int [8];
	
	for (int i = 0; i < 6 ; i++) {
		
		int maxScore = 0;
		for (int j = 0; j < 8; j++) {
			if (exam[i][j] > maxScore) {
				maxScore = exam[i][j];
			}
		}
		
		for (int k = 0; k<8; k++) {
			if (exam[i][k] == maxScore) {
				student[k]++;
			}
		}
	}
	for (int l = 1; l<9;l++) {
		System.out.println(l+"號同學考最高分的次數="+student[l-1]+"次");
	}
	
}
 }
