package com.grybos.kamil.patternsproject.database;

import com.grybos.kamil.patternsproject.model.Customer;
import com.grybos.kamil.patternsproject.model.Employee;
import com.grybos.kamil.patternsproject.repository.CustomerRepository;
import com.grybos.kamil.patternsproject.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Adding!");
        this.employeeRepository.save(new Employee("Joe Biden", 45, 5));
        this.employeeRepository.save(new Employee("President Obama", 54, 8));
        this.employeeRepository.save(new Employee("Crystal Mac", 34, 12));
        this.employeeRepository.save(new Employee("James Henry", 33, 2));

        this.customerRepository.save(new Customer("Kamil", "Grybos"));
        this.customerRepository.save(new Customer("Marek", "Bronski"));
        this.customerRepository.save(new Customer("Kamil", "Górski"));
    }
}