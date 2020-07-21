package com.yilin.springboot.demo.springbootdemo.service;

import com.yilin.springboot.demo.springbootdemo.dao.EmployeeRepository;
import com.yilin.springboot.demo.springbootdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
