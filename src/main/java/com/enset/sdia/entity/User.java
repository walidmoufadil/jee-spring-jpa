package com.enset.sdia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor@ToString@Builder
public class User {
    @Id
    private String id;
    @Column(unique=true,length = 20)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
}
