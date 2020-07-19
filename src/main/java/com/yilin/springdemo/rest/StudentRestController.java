package com.yilin.springdemo.rest;

import com.yilin.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        // Only load once
        students = new ArrayList<>();
        students.add(new Student("Ellie", "Miller"));
        students.add(new Student("Joel", "Miller"));
        students.add(new Student("Lisa", "Shell"));

    }

    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    //define endpoint for "/students/:studentId"
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return students.get(studentId);
    }
}
