package com.enset.sdia.repository;

import com.enset.sdia.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IConsultationRepo extends JpaRepository<Consultation, Long> {

}
