package com.enset.sdia.service.Impl;

import com.enset.sdia.entity.Consultation;
import com.enset.sdia.repository.IConsultationRepo;
import com.enset.sdia.service.IConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements IConsultationService {
    @Autowired
    private IConsultationRepo iConsultationRepo;

    public List<Consultation> getAllConsultation(){
        return iConsultationRepo.findAll();
    }
    public Consultation getConsultationById(long id) {
        return iConsultationRepo.findById(id).orElseThrow(()-> new RuntimeException("Consultation Not Found"));
    }
    public Consultation saveConsultation(Consultation consultation) {
        return iConsultationRepo.save(consultation);
    }

    public void deleteConsultation(Consultation consultation) {
        iConsultationRepo.delete(consultation);
    }

}
