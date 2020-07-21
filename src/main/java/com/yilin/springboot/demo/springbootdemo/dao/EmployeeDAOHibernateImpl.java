package com.yilin.springboot.demo.springbootdemo.dao;

import com.yilin.springboot.demo.springbootdemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manger
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        // Constructor injection
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // creat a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);
        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery(
                "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);
        theQuery.executeUpdate();
    }
}
