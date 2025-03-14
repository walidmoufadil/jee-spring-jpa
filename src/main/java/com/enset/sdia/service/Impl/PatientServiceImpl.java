package com.enset.sdia.service.Impl;

import com.enset.sdia.entity.Patient;
import com.enset.sdia.repository.IPatientRepo;
import com.enset.sdia.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
    IPatientRepo iPatientRepo;

    public List<Patient> getAllPatients() {
        return iPatientRepo.findAll();
    }
    public Patient getPatientById(long id) {
        return iPatientRepo.findById(id).orElseThrow(()-> new RuntimeException("Patient Not Found"));
    }

    @Override
    public Patient getPatientsByName(String name) {
        return iPatientRepo.findByName(name);
    }

    public Patient savePatient(Patient patient) {
        return iPatientRepo.save(patient);
    }
    public void deletePatient(long id) {
        iPatientRepo.deleteById(id);
    }

    @Override
    public Page<Patient> findPatients(boolean malade, Pageable pageable) {
        return iPatientRepo.findByMalade(malade,pageable);
    }

}
