/*
 * @(#)OperationService.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atm.exception.InsufficientFundsException;
import br.com.atm.model.Customer;
import br.com.atm.model.dto.WithdrawalDto;

/**
 * <p>
 * The class <code>OperationService.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
@Service
public class OperationService {

	@Autowired
	private CustomerService customerService; 
	
	public WithdrawalDto saque(final String id, final double value) {
		
		customerService.withdrawal(id, value);
		
		return new WithdrawalDto(value);
	}

}
