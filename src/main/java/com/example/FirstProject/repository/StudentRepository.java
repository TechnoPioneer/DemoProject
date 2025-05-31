package com.example.FirstProject.repository;

import com.example.FirstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

   @Query(value = "select * from students where name =:name and college = :college", nativeQuery = true)
   List<Student> findByNativeQuery(@Param("name") String name, @Param("college") String college);

   @Query("select s from Student s where s.name = :name")
   List<Student> findByJPA(@Param("name") String name);

   Optional<Student> findByName(String name);
}
