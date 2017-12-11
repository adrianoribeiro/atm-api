/*
 * @(#)CustomerService.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.atm.exception.InsufficientFundsException;
import br.com.atm.model.Customer;
import br.com.atm.model.dto.WithdrawalDto;
import br.com.atm.repository.CustomerRepository;

/**
 * <p>
 * The class <code>CustomerService.java</code> 
 * </p>
 *
 * @author Mult-e
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void save(final Customer customer){
		customerRepository.save(customer);
	}
	
	public Customer findOne(final String id){
		return customerRepository.findOne(id);
	}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public void delete(final String id){
		customerRepository.delete(id);
	}

	@Transactional
	@Async("threadPoolTaskExecutor")
	public WithdrawalDto withdrawal(final String id, double value) {
		
		System.out.println("Entrou na thread: "+Thread.currentThread().getName());

		final Customer customer = this.findOne(id);
		customer.withdrawal(value);
		
		if(customer.getBalance() < 0){
			throw new InsufficientFundsException();
		}
		
		this.save(customer);
		
		return new WithdrawalDto(value);
	}
}
