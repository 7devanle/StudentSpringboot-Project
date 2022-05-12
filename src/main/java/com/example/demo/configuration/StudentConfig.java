package com.example.demo.configuration;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (IStudentRepository repository) {
        return args -> {
           Student obi =  new Student(
                    1L,
                    "Obi Cubanna",
                    "Cubannarails@gmail.com",
                    LocalDate.of(1969, 12, 01)
            );
            Student alex =  new Student(
                    2L,
                    "Alex Ferguson",
                    "Fuegos@gmail.com",
                    LocalDate.of(1956, 02, 21)
            );
            repository.saveAll(List.of(obi, alex));
        };
    }
}
