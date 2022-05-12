package com.example.demo.servies;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class StudentServices {

    private final IStudentRepository iStudentRepository;

    @Autowired
    public StudentServices(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    public List<Student> getStudents() {
        return iStudentRepository.findAll();

    }
}
