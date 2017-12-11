/*
 * @(#)InsufficientFundsException.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, adriano.ribeiro
 */
package br.com.atm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>
 * The class <code>InsufficientFundsException.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Insufficient funds.")
public class InsufficientFundsException extends RuntimeException {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -3449439018115114088L;
}
