package hw6;

public class Calculator {


	    public int powerXY(int x, int y) {

	        if (x == 0 && y == 0) {
	            System.out.println("0的0次方沒有意義！");
	            throw new CalException("0的0次方沒有意義！"); //拋出自定義的例外，並自定義例外的訊息
	        } else if (y < 0) {
	            System.out.println("次方為負值，結果回傳不為整數！");
	            throw new CalException("次方為負值，結果回傳不為整數！"); 
	        } else {
	            return (int) Math.pow(x, y);
	        }
	    }
	}


