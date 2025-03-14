package com.enset.sdia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Consultation consultation;
}
