package com.grybos.kamil.patternsproject.resources;

import com.grybos.kamil.patternsproject.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.security.access.prepost.PreAuthorize;

@CrossOrigin(methods =
        {
                RequestMethod.POST,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        },
        allowCredentials = "false")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @Override
//    void delete(Long aLong);

}