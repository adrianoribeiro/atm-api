/*
 * @(#)CustomThreadFactory.java 1.0 10 de dez de 2017
 *
 * Copyright (c) 2017, adriano.ribeiro
 */
package br.com.atm.factory;

import java.util.concurrent.ThreadFactory;

import br.com.atm.exception.CustomThreadException;

/**
 * <p>
 * The class <code>CustomThreadFactory.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 10 de dez de 2017
 * @version 1.0 10 de dez de 2017
 */
public class CustomThreadFactory implements ThreadFactory {

	private static int numero = 1;

	@Override
	public Thread newThread(Runnable task) {
        Thread thread = new Thread(task, "XPTO-MyThread-ATM-" + numero);
        numero++;
        thread.setUncaughtExceptionHandler(new CustomThreadException());
        return thread;
	}

}
