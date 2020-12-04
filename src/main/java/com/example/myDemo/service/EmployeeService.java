package com.example.myDemo.service;

import com.example.myDemo.model.Employee;
import com.example.myDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Employee> getEmployees(String last_name){
        return employeeRepository.findEmployeesByLastName(last_name);
    }

}

