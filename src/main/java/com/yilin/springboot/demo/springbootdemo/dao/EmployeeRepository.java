package com.yilin.springboot.demo.springbootdemo.dao;

import com.yilin.springboot.demo.springbootdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
