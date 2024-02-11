package hw6;

public class CalException extends RuntimeException { //也可extends Throwable、Exception
	public CalException() { //空建構子
	}

	public CalException(String message) { //自定義例外訊息的建構子
		super(message);
	}

}

