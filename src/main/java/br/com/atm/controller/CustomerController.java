/*
 * @(#)CustomerController.java 1.0 8 de dez de 2017
 *
 * Copyright (c) 2017, adriano.ribeiro
 */
package br.com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.atm.model.Customer;
import br.com.atm.model.dto.WithdrawalDto;
import br.com.atm.service.CustomerService;

/**
 * <p>
 * The class <code>CustomerController.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 8 de dez de 2017
 * @version 1.0 8 de dez de 2017
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Customer findOne(@PathVariable String id){
		return customerService.findOne(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Customer customer){
		customerService.save(customer);
	}
	
	@PutMapping(value="/withdrawal/{id}/{value}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public WithdrawalDto withdrawal(@PathVariable String id, @PathVariable String value){
		
		return customerService.withdrawal(id, Double.parseDouble(value));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		customerService.delete(id);
	}
}
