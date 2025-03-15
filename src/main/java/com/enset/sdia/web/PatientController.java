package com.enset.sdia.web;

import com.enset.sdia.entity.Patient;
import com.enset.sdia.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    private IPatientService patientService;

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }
    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

}
