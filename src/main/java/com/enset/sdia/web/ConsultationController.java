package com.enset.sdia.web;

import com.enset.sdia.entity.Consultation;
import com.enset.sdia.service.IConsultationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultation")
@AllArgsConstructor
public class ConsultationController {
    private IConsultationService consultationService;
    @GetMapping("/all")
    public List<Consultation> getAll() {
        return consultationService.getAllConsultation();
    }
    @GetMapping("/{id}")
    public Consultation getConsultation(@PathVariable Long id) {
        return consultationService.getConsultationById(id);
    }
    @PostMapping("/add")
    public void addConsultation(@RequestBody Consultation consultation) {
        consultationService.saveConsultation(consultation);
    }
}
