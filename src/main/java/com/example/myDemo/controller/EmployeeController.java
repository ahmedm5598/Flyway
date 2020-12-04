package com.example.myDemo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.example.myDemo.model.Employee;
import com.example.myDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //getEmployees
    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return this.employeeRepository.findAll();
    }
    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId){
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        //  .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        if(!employee.isPresent())
            return ResponseEntity.badRequest().body(null);
        String data = "";
        try {
            File myObj = new File("url.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return secondServiceClient.getEmployeeById(URI.create(data),employeeId);
        //return ResponseEntity.ok().body(employee.get());
    }

    //save employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @RequestBody Employee employeeDetails){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(!employee.isPresent())
             return ResponseEntity.badRequest().body("Employee not found for this id");

        employee.get().setEmail(employeeDetails.getEmail());
        employee.get().setLastName(employeeDetails.getLastName());
        employee.get().setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee.get());
        return ResponseEntity.ok(updatedEmployee);
    }
    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(!employee.isPresent())
            return ResponseEntity.badRequest().body("Employee not found for this id");
        employeeRepository.delete(employee.get());
        return ResponseEntity.ok().body("Employee deleted");
    }
}
