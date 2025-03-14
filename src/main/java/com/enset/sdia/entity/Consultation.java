package com.enset.sdia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Consultation {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    private String rapportConsultation;
    @OneToOne
    private RendezVous rendezVous;
}
