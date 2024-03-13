package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        return studentCourseRepository.findAll();
    }

    public Optional<Student> findStudentWithHighestGpa() {
        Student highestGPA = studentRepository.findHighestGPA();    
        return Optional.ofNullable(highestGPA);
    }

    public String joinStudentNames() {
        // Source
        // https://dip-mazumder.medium.com/stringbuilder-vs-string-in-java-a-guide-for-optimal-memory-usage-4a284d8243ea#:~:text=%60StringBuilder%60%20outperforms%20%60String%60,modification%2C%20and%20large%20string%20construction.
        List<Student> students = studentRepository.findAll();
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.getName()).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}

