package com.enset.sdia.service;

import com.enset.sdia.entity.Consultation;

import java.util.List;

public interface IConsultationService {
    public List<Consultation> getAllConsultation();
    public Consultation getConsultationById(long id);
    public Consultation saveConsultation(Consultation consultation);
    public void deleteConsultation(Consultation consultation);
}
