package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}