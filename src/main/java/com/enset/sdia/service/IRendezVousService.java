package com.enset.sdia.service;

import com.enset.sdia.entity.RendezVous;
import java.util.List;

public interface IRendezVousService {
    public List<RendezVous> getAllRendezVous();
    public RendezVous getRendezVousById(Long id);
    public RendezVous saveRendezVoud(RendezVous rendezVous);
    public void deleteRendezVous(Long id);
}
