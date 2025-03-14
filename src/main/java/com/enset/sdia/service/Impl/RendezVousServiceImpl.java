package com.enset.sdia.service.Impl;

import com.enset.sdia.entity.RendezVous;
import com.enset.sdia.repository.IRendezVousRepo;
import com.enset.sdia.service.IRendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousServiceImpl implements IRendezVousService {
    @Autowired
    IRendezVousRepo iRendezVousRepo;

    public List<RendezVous> getAllRendezVous() {
        return iRendezVousRepo.findAll();
    }
    public RendezVous getRendezVousById(Long id) {
        return iRendezVousRepo.findById(id).orElseThrow(()-> new RuntimeException("Rendez Vous not found"));
    }
    public RendezVous saveRendezVoud(RendezVous rendezVous) {
        return iRendezVousRepo.save(rendezVous);
    }
    public void deleteRendezVous(Long id) {
        iRendezVousRepo.deleteById(id);
    }
}
