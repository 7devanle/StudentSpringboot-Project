package com.example.demo.servies;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


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

    public void addStudent(Student student) {
        Optional<Student> studentOptional = iStudentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        iStudentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = iStudentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with ID " + studentId + " does not exist");
        }
        iStudentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = iStudentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException(
                        "student with ID " + studentId + " does not exists"
                )
        );
        if(name!= null && name.length()>0 &&
            !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email!= null && email.length()>0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = iStudentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already exists");
            }
            student.setEmail(email);
        }
    }
}
