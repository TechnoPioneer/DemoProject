package com.example.FirstProject.repository;

import com.example.FirstProject.model.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserName(String userName);
}
