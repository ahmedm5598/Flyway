package com.example.myDemo.controller;
import com.example.myDemo.model.Employee;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@FeignClient(name = "dummy-name", url = "https://this-is-a-placeholder.com")
public interface SecondServiceClient {
    @RequestLine("GET")
    @RequestMapping(method=RequestMethod.GET, value="/api/v2/employees")
    public List<Employee> getAllEmployee(URI baseUrl);

//    get employee by id
    @RequestLine("GET")
    @RequestMapping(method=RequestMethod.GET, value="/api/v2/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(URI baseUrl, @PathVariable(value = "id") Long employeeId);
//
//    //save employee
//    @PostMapping("/employees")
//    public Employee createEmployee(URI baseUrl,@RequestBody Employee employee);
//    //update employee
//    @PutMapping("/employees/{id}")
//    public ResponseEntity updateEmployee(URI baseUrl,@PathVariable(value = "id") Long employeeId,
//                                         @RequestBody Employee employeeDetails);
//    //delete employee
//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity deleteEmployee(URI baseUrl,@PathVariable(value = "id") Long employeeId);
}
