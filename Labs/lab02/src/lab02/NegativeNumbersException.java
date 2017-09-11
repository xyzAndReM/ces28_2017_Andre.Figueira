package lab02;

public class NegativeNumbersException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6408549187363175418L;

	NegativeNumbersException(String message) {
	    super("negativos proibidos " + message);
	  }
}
