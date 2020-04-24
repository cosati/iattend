package br.com.cosati.iattend.services.exceptions;

public class ConversionFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ConversionFailedException(String msg) {
		super(msg);
	}

	public ConversionFailedException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
