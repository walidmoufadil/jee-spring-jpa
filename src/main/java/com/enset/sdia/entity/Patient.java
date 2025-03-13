package com.enset.sdia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor@Builder@ToString
@Entity
public class Patient {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
