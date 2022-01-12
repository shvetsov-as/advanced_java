package questionPack;

public class MyException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int excNumber;
	
	MyException(String message, int excNumber){
		super(message);
		this.excNumber = excNumber;

	}

	public String getMsg() {
		return message;
	}

	public int getNumber() {
		return excNumber;
	}



}
