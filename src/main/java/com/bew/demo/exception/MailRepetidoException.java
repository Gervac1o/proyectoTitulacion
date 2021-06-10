package com.bew.demo.exception;

import java.io.IOException;

public class MailRepetidoException extends Throwable {

	public MailRepetidoException(String message, IOException ex) {
		super(message, ex);
	}
	public MailRepetidoException(String s) {
		super(s);
	}


}
