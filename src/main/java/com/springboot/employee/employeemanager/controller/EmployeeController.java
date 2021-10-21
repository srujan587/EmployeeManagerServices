package com.springboot.employee.employeemanager.controller;

import com.springboot.employee.employeemanager.model.Employee;
import com.springboot.employee.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> findAllEmployees(){
        List<Employee> listEmployees=employeeService.findAllEmployees();
        return new ResponseEntity(listEmployees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee=employeeService.findEmployee(id);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employeeNew=employeeService.addEmployee(employee);
        return new ResponseEntity(employeeNew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employeeNew=employeeService.updateEmployee(employee);
        return new ResponseEntity(employeeNew, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String name){
        List<Employee> listOfEmployees=employeeService.searchEmployee(name);
        return new ResponseEntity(listOfEmployees,HttpStatus.OK);
    }
}
