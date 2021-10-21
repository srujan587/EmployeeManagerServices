package com.springboot.employee.employeemanager.repo;

import com.springboot.employee.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    @Query("Select e from Employee e where e.name like :name%")
    public List<Employee> searchEmployee(String name);
}