package one.digitalinovation.gof.util.exceptions;

public class InvalidEmailEception extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidEmailEception(String msg) {
		super(msg);
	}
}
