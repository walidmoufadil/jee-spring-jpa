package com.enset.sdia.repository;

import com.enset.sdia.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContains(String name);
    void deleteById(Long id);
    @Query("UPDATE Patient p SET p.name = :#{#patient.name}, p.score = :#{#patient.score}, p.dateNaissance = :#{#patient.dateNaissance}, p.malade = :#{#patient.malade} WHERE p.id = :id")
    int updateUserName(@Param("id") Long id, @Param("patient") Patient patient);
}
