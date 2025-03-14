package com.enset.sdia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class RendezVous {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    @Temporal(TemporalType.TIME)
    private Date heureRDV;
    @Enumerated(EnumType.STRING)
    private StatusRdv statusRdv;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
