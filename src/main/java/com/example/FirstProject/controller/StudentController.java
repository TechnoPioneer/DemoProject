package com.example.FirstProject.controller;

import com.example.FirstProject.exception.ErrorResponse;
import com.example.FirstProject.exception.StudentNotFoundException;
import com.example.FirstProject.model.Student;
import com.example.FirstProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public ResponseEntity<List<Student>>  getAllStudents(){
        List<Student> students =  service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentById(@RequestParam int id) {

            Student student = service.fetchStudentById(id).orElseThrow(() -> new StudentNotFoundException("No Student with id: " + id));
            return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/student/{name}/college/{college}")
    public List<Student> getStudentsByNative(@PathVariable String name, @PathVariable  String college) {
        return service.getByNativeQuery(name,college);
    }

    @GetMapping("/student/name")
    public List<Student> getStudentsByJPA(@RequestParam(required = true) String name) {
        return service.getByJPAQuery(name);
    }

    @GetMapping("/student/sports")
    public List<Student> getStudentsBySports () {
        return service.getStudentsBySports();
    }
}
