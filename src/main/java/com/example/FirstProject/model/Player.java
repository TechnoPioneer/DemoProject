package com.example.FirstProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;

     private int student_id;

     String sports;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
