package com.enset.sdia.repository;

import com.enset.sdia.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
public interface IMedecinRepo extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContains(String name);
    Page<Patient> findByMalade(boolean malade, Pageable pageable);
}
