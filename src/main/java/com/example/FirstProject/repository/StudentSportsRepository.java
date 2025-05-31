package com.example.FirstProject.repository;

import com.example.FirstProject.model.Player;
import com.example.FirstProject.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentSportsRepository {

    @Autowired
    private EntityManager entityManager;


    public List<Student> getAllFilteredStudents() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);
        Join<Student, Player> playerJoin = studentRoot.join("players", JoinType.INNER);

        Predicate predicate = cb.equal(playerJoin.get("sports"), "cricket");

        cq.where(predicate);

        cq.select(studentRoot).distinct(true);
        // Step 7: Run the query
        TypedQuery<Student> query = entityManager.createQuery(cq);
        return query.getResultList();

    }


}
