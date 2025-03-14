package com.enset.sdia.service;

import com.enset.sdia.entity.Medecin;
import java.util.List;

public interface IMedecinService {
    public List<Medecin> getAllMedecin();
    public Medecin getMedecinById(long id);
    public Medecin getMedecinByName(String name);
    public Medecin saveMedecin(Medecin medecin);
    public void deleteMedecin(long id);
}
