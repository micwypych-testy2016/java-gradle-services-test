package pl.edu.agh.kis.javagradleservicestest.exceptions;

public class ApplicationException extends RuntimeException {

	public ApplicationException(Exception e) {
		super(e);
	}

}
