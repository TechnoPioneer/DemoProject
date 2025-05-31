package com.example.FirstProject.service;

import com.example.FirstProject.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> fetchStudentById(Integer id);

     List<Student> getByNativeQuery(String name, String college);

     List<Student> getByJPAQuery(String name);

     List<Student> getStudentsBySports();

     Optional<Student> getByStudentName(String name);
}
