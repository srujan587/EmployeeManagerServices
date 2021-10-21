package com.springboot.employee.employeemanager.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeRepoTest {
    @Autowired
    private  EmployeeRepo repo;

    @Test
    public void testSearchEmployee(){
        System.out.println(repo.searchEmployee("sru"));
    }
}
