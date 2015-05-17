package exeptions;

public class WebtasksException extends Exception {

	public WebtasksException(String message) {
		super(message);
	}

	public WebtasksException(Throwable cause) {
		super(cause);
	}

	public WebtasksException(String message, Throwable cause) {
		super(message, cause);
	}
}
