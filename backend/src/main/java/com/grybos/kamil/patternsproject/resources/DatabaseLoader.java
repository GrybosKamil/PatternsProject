package com.grybos.kamil.patternsproject.resources;

import com.grybos.kamil.patternsproject.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    private final EmployeeRepository repository;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Adding!");
        this.repository.save(new Employee("Joe Biden", 45, 5));
        this.repository.save(new Employee("President Obama", 54, 8));
        this.repository.save(new Employee("Crystal Mac", 34, 12));
        this.repository.save(new Employee("James Henry", 33, 2));
    }
}