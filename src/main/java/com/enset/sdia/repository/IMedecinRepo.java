package com.enset.sdia.repository;

import com.enset.sdia.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedecinRepo extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String medecinName);
}
