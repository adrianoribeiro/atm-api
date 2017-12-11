/*
 * @(#)CustomThreadException.java 1.0 10 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * <p>
 * The class <code>CustomThreadException.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 10 de dez de 2017
 * @version 1.0 10 de dez de 2017
 */
public class CustomThreadException implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable e) {
		System.out.println("Exceção na thread " + thread.getName() + ": " + e.getMessage());
	}

}
