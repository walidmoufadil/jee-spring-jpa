package com.enset.sdia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true,length = 20)
    private String rolename;
    private String description;
    @ManyToMany
    @ToString.Exclude
    private List<User> users;

}
