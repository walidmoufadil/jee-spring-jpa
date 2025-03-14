package com.enset.sdia;

import com.enset.sdia.entity.*;
import com.enset.sdia.repository.IConsultationRepo;
import com.enset.sdia.repository.IMedecinRepo;
import com.enset.sdia.repository.IPatientRepo;
import com.enset.sdia.repository.IRendezVousRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx, IPatientRepo iPatientRepo, IMedecinRepo iMedecinRepo, IRendezVousRepo iRendezVousRepo, IConsultationRepo iConsultationRepo) {
        return args -> {
            Stream.of("Maria","John","Franck","Mohammed")
                    .forEach(
                            name -> {
                                Patient  patient = new Patient();
                                patient.setName(name);
                                patient.setScore((int)(Math.random() * 100));
                                patient.setMalade(Math.random()  > 0.5);
                                patient.setDateNaissance(new Date());
                                iPatientRepo.save(patient);
                            }
                    );

            Stream.of("Marie","Youssef","Ahmed","Yousra")
                    .forEach(
                            name -> {
                                Medecin  medecin = new Medecin();
                                medecin.setNom(name);
                                medecin.setEmail(name+"@gmail.com");
                                medecin.setSpecialite("general");
                                iMedecinRepo.save(medecin);
                            }
                    );
            RendezVous rendezVous = new RendezVous();
            rendezVous.setStatusRdv(StatusRdv.PENDING);
            rendezVous.setDateRDV(new Date());
            rendezVous.setHeureRDV(new Date());
            Medecin medecin = iMedecinRepo.findById((long)1).orElse(null);
            Patient patient = iPatientRepo.findById((long)2).orElse(null);

            if(medecin != null) {
                rendezVous.setMedecin(medecin);
            }

            if(medecin != null) {
                rendezVous.setPatient(patient);
            }
            iRendezVousRepo.save(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous);
            consultation.setRapportConsultation("Vous trouverez ci-dessous le rapport du consultation, ..........");
            iConsultationRepo.save(consultation);



            System.out.println("==========================Liste Patient====================================");
            Page<Patient> patients = iPatientRepo.findAll(PageRequest.of(0,5));
            patients.forEach(System.out::println);

            System.out.println("==========================Update Patient====================================");
            Patient patient1 = iPatientRepo.findById((long) 1).orElse(null);

            if(patient1 != null) {
                patient1.setMalade(true);
                iPatientRepo.save(patient);
            }

            System.out.println("==========================List Patient(Filter By Name)====================================");
            iPatientRepo.findByNameContains("John").forEach(System.out::println);
            Page<Patient> patients1 = iPatientRepo.findByMalade(true,PageRequest.of(0,4));
            patients1.forEach(System.out::println);

            /*
            * Delete Patient
            */
            iPatientRepo.deleteById((long) 1);

        };


    }
}

