package com.enset.sdia.repository;

import com.enset.sdia.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRendezVousRepo extends JpaRepository<RendezVous, Long> {

}
