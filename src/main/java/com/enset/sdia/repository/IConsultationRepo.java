package com.enset.sdia.repository;

import com.enset.sdia.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultationRepo extends JpaRepository<Consultation, Long> {
}
