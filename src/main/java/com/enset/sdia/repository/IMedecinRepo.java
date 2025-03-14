package com.enset.sdia.repository;

import com.enset.sdia.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMedecinRepo extends JpaRepository<Medecin, Long> {
    List<Medecin> findByNom(String medecinName);
}
