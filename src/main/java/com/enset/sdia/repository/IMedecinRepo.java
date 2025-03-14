package com.enset.sdia.repository;

import com.enset.sdia.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMedecinRepo extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String medecinName);
}
