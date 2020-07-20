package com.yilin.springdemo.rest;

import com.yilin.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student id not found");
        }
        return students.get(studentId);
    }

}
