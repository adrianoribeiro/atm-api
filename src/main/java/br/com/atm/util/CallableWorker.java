/*
 * @(#)CallableWorker.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.util;

import java.util.concurrent.Callable;

/**
 * <p>
 * The class <code>CallableWorker.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
public class CallableWorker implements Callable<String>{

	String name;
    
    public CallableWorker(String name) {
        this.name = name;
    }
     
    @Override
    public String call() throws Exception {
        process();
        String message = String.format("CallableWorker name: %s is Done", name);
        return message;
    }
     
    private void process(){ 
        for(int taskId=0; taskId < 10; taskId++){
            String message = String.format("CallableWorker name: %s is processing a taskId: %d", name, taskId);
            System.out.println(message);
        }
    }

}
