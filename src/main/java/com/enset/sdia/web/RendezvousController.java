package com.enset.sdia.web;

import com.enset.sdia.entity.RendezVous;
import com.enset.sdia.service.IRendezVousService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
@AllArgsConstructor
public class RendezvousController {
    private IRendezVousService rendezVousService;

    @GetMapping("/all")
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }
    @GetMapping("/{id}")
    public RendezVous getRendezVous(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id);
    }
    @PostMapping("/add")
    public void addRendezVous(@RequestBody RendezVous rendezVous) {
        rendezVousService.saveRendezVoud(rendezVous);
    }
}
