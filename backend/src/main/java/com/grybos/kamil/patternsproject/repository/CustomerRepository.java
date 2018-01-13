package com.grybos.kamil.patternsproject.repository;

import com.grybos.kamil.patternsproject.model.Customer;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @Override
//    void delete(Long aLong);

}