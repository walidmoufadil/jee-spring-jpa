package com.enset.sdia.web;

import com.enset.sdia.entity.Medecin;
import com.enset.sdia.service.IMedecinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medecin")
public class MedecinController {
    private IMedecinService medecinService;
    @GetMapping("/all")
    public List<Medecin> getAllMedecin() {
        return medecinService.getAllMedecin();
    }
    @GetMapping("/id")
    private Medecin getMedecinById(long id) {
        return medecinService.getMedecinById(id);
    }
    @PostMapping("/add")
    public Medecin addMedecin(@RequestBody Medecin medecin) {
        return medecinService.saveMedecin(medecin);
    }
}
