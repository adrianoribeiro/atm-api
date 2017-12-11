/*
 * @(#)Customer.java 1.0 8 de dez de 2017
 *
 * Copyright (c) 2017, adriano.ribeiro
 */
package br.com.atm.model;

import org.springframework.data.annotation.Id;

/**
 * <p>
 * The class <code>Customer.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 8 de dez de 2017
 * @version 1.0 8 de dez de 2017
 */
public class Customer {
	@Id
	private String id;
	private String name;
	private Double balance;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void withdrawal(double value) {
		this.balance -= value; 
	}
}
