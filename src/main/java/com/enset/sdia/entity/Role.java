package com.enset.sdia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> users;

}
