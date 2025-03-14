package com.enset.sdia.service;

import com.enset.sdia.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService {
    public List<Patient> getAllPatients();
    public Patient getPatientById(long id);
    public Patient getPatientsByName(String name);
    public Patient savePatient(Patient patient);
    public void deletePatient(long id);
    public Page<Patient> findPatients(boolean malade,Pageable pageable);
}
