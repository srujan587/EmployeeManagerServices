package com.springboot.employee.employeemanager.service;

import com.springboot.employee.employeemanager.exception.EmployeeNotFoundException;
import com.springboot.employee.employeemanager.model.Employee;
import com.springboot.employee.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }

    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee findEmployee(Long id){
        return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee ID:"+id));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    public List<Employee> searchEmployee(String name){
        return employeeRepo.searchEmployee(name);
    }
}
