package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.servies.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "school/students")
public class StudentController {

    private StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentServices.getStudents();
    }
    @PostMapping
    public void registerStudent(@RequestBody Student student){
        studentServices.addStudent(student);
    }
}
