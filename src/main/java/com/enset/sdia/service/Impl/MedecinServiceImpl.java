package com.enset.sdia.service.Impl;

import com.enset.sdia.entity.Medecin;
import com.enset.sdia.repository.IMedecinRepo;
import com.enset.sdia.service.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinServiceImpl implements IMedecinService {
    @Autowired
    private IMedecinRepo iMedecinRepo;

    public List<Medecin> getAllMedecin() {
        return iMedecinRepo.findAll();
    }
    public Medecin getMedecinById(long id) {
        return iMedecinRepo.findById(id).orElseThrow(()->new RuntimeException("Medecin not found"));
    }

    @Override
    public Medecin getMedecinByName(String name) {
        return iMedecinRepo.findByNom(name);
    }

    public Medecin saveMedecin(Medecin medecin) {
         return iMedecinRepo.save(medecin);
    }
    public void deleteMedecin(long id) {
        iMedecinRepo.deleteById(id);
    }
}
