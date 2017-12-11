/*
 * @(#)CustomerRepository.java 1.0 9 de dez de 2017
 *
 * Copyright (c) 2017, Mult-e
 */
package br.com.atm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.atm.model.Customer;

/**
 * <p>
 * The class <code>CustomerRepository.java</code> 
 * </p>
 *
 * @author adriano.ribeiro
 * @since 9 de dez de 2017
 * @version 1.0 9 de dez de 2017
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
