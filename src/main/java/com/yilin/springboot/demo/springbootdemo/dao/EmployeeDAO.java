package com.yilin.springboot.demo.springbootdemo.dao;

import com.yilin.springboot.demo.springbootdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
