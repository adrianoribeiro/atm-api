/*
 * @(#)ThreadPoolConfiguration.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, adriano.ribeiro
 */
package br.com.atm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import br.com.atm.factory.CustomThreadFactory;

/**
 * <p>
 * The class <code>ThreadPoolConfiguration.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
@Configuration
public class ThreadPoolConfiguration {

    @Value("${atmthreadpool.corepoolsize}")
    int corePoolSize;
     
    @Value("${atmthreadpool.maxpoolsize}")
    int maxPoolSize;
     
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        
        pool.setThreadFactory(new CustomThreadFactory());
        
        pool.setCorePoolSize(corePoolSize);
        pool.setMaxPoolSize(maxPoolSize);
        
        return pool;
    }
}
