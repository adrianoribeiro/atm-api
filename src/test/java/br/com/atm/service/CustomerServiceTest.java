/*
 * @(#)OperationServiceTest.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.atm.exception.InsufficientFundsException;
import br.com.atm.model.Customer;
import br.com.atm.model.dto.WithdrawalDto;
import br.com.atm.repository.CustomerRepository;

/**
 * <p>
 * The class <code>OperationServiceTest.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
@RunWith(PowerMockRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService service;
	
	@Mock
	private CustomerRepository customerRepository;
	
	private Customer customer;
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
		customer.setId("string_id");
		customer.setName("Adriano");
		customer.setBalance(1000D);
	}

	@Test
	public void saque80(){
		
		when(customerRepository.findOne("string_id")).thenReturn(customer);
		WithdrawalDto withdrawalDto = service.withdrawal("string_id", 80d);
		
		assertEquals(0, withdrawalDto.getOne());
		assertEquals(0, withdrawalDto.getTwo());
		assertEquals(0, withdrawalDto.getFive());
		assertEquals(1, withdrawalDto.getTen());
		assertEquals(1, withdrawalDto.getTwenty());
		assertEquals(1, withdrawalDto.getFifty());
		assertEquals(0, withdrawalDto.getHundred());
	}
	
	@Test
	public void saque259(){
		
		when(customerRepository.findOne("string_id")).thenReturn(customer);
		WithdrawalDto withdrawalDto = service.withdrawal("string_id", 259d);
		
		assertEquals(0, withdrawalDto.getOne());
		assertEquals(2, withdrawalDto.getTwo());
		assertEquals(1, withdrawalDto.getFive());
		assertEquals(0, withdrawalDto.getTen());
		assertEquals(0, withdrawalDto.getTwenty());
		assertEquals(1, withdrawalDto.getFifty());
		assertEquals(2, withdrawalDto.getHundred());
	}

	@Test(expected=InsufficientFundsException.class)
	public void insufficientFunds(){
		
		when(customerRepository.findOne("string_id")).thenReturn(customer);
		service.withdrawal("string_id", 2000d);
	}
}
