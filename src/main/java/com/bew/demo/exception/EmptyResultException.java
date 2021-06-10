package com.bew.demo.exception;

import org.springframework.http.HttpStatus;

public class EmptyResultException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyResultException(String s, Long id) {
    }

    public EmptyResultException(String s) {
    	
    }
	

}
