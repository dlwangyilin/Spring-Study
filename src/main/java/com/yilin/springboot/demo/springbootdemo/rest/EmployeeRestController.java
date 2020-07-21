package com.yilin.springboot.demo.springbootdemo.rest;

import com.yilin.springboot.demo.springbootdemo.dao.EmployeeDAO;
import com.yilin.springboot.demo.springbootdemo.entity.Employee;
import com.yilin.springboot.demo.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        // constructor injection
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


}
