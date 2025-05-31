package com.example.FirstProject.serviceImpl;

import com.example.FirstProject.model.Student;
import com.example.FirstProject.repository.StudentRepository;
import com.example.FirstProject.repository.StudentSportsRepository;
import com.example.FirstProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentSportsRepository studentSportsRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students =  studentRepository.findAll();
        return students;
    }

    @Override
    public Optional<Student> fetchStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getByNativeQuery(String name, String college) {
        List<Student> students = studentRepository.findByNativeQuery(name, college);
        return students;
    }

    @Override
    public List<Student> getByJPAQuery(String name) {
        List<Student> students = studentRepository.findByJPA(name);
        return students;
    }

    @Override
    public List<Student> getStudentsBySports() {
        return studentSportsRepository.getAllFilteredStudents();
    }

    @Override
    public Optional<Student> getByStudentName(String name) {

        return (studentRepository.findByName(name));
    }


}
