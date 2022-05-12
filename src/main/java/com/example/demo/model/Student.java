package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"

    )
    private Long id;

    private String name;
    private String email;
    @Transient
    private int age;
    private LocalDate Dirth_of_birth;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate Date_of_birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Dirth_of_birth = Date_of_birth;
    }

    public Student(String name, String email, LocalDate DOB) {
        this.name = name;
        this.email = email;
        this.Dirth_of_birth = DOB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(this.Dirth_of_birth, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDirth_of_birth() {
        return Dirth_of_birth;
    }

    public void setDirth_of_birth(LocalDate dirth_of_birth) {
        this.Dirth_of_birth = dirth_of_birth;
    }

    @Override
    public String toString() {
        return "Student{ " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", email = '" + email + '\'' +
                ", age = " + age +
                ", Dirth_of_birth = " + Dirth_of_birth +
                '}';
    }
}
