package com.enset.sdia.repository;

import com.enset.sdia.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Page<Patient> findByMalade(boolean malade, Pageable pageable);
}
