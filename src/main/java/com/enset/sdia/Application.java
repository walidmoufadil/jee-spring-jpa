package com.enset.sdia;

import com.enset.sdia.entity.*;
import com.enset.sdia.service.IConsultationService;
import com.enset.sdia.service.IMedecinService;
import com.enset.sdia.service.IPatientService;
import com.enset.sdia.service.IRendezVousService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx,IConsultationService iConsultationService, IRendezVousService iRendezVousService, IMedecinService iMedecinService, IPatientService iPatientService) {
        return args -> {
            Stream.of("Maria","John","Franck","Mohammed")
                    .forEach(
                            name -> {
                                Patient  patient = new Patient();
                                patient.setName(name);
                                patient.setScore((int)(Math.random() * 100));
                                patient.setMalade(Math.random()  > 0.5);
                                patient.setDateNaissance(new Date());
                                iPatientService.savePatient(patient);
                            }
                    );

            Stream.of("Marie","Youssef","Ahmed","Yousra")
                    .forEach(
                            name -> {
                                Medecin  medecin = new Medecin();
                                medecin.setNom(name);
                                medecin.setEmail(name+"@gmail.com");
                                medecin.setSpecialite("general");
                                iMedecinService.saveMedecin(medecin);
                            }
                    );
            RendezVous rendezVous = new RendezVous();
            rendezVous.setStatusRdv(StatusRdv.PENDING);
            rendezVous.setDateRDV(new Date());
            rendezVous.setHeureRDV(new Date());

            rendezVous.setMedecin(iMedecinService.getMedecinById(1L));
            rendezVous.setPatient(iPatientService.getPatientById(2L));


            iRendezVousService.saveRendezVoud(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous);
            consultation.setRapportConsultation("Vous trouverez ci-dessous le rapport du consultation, ..........");
            iConsultationService.saveConsultation(consultation);



            System.out.println("==========================Liste Patient====================================");
            iPatientService.getAllPatients().forEach(p -> {
                System.out.println(p.getId()+" "+p.getName()+" "+p.getScore()+" "+p.getDateNaissance());
            });


            System.out.println("==========================Patient(Search By Name)====================================");
            Patient patient = iPatientService.getPatientsByName("John");
            System.out.println(patient.getId()+" "+patient.getName()+" "+patient.getScore()+" "+patient.getDateNaissance());

            System.out.println("==========================Patients(Search By malade)====================================");
            iPatientService.findPatients(true,PageRequest.of(0,4)).forEach(p -> {
                System.out.println(p.getId()+" "+p.getName()+" "+p.getScore()+" "+p.getDateNaissance());
            });

            /*
            * Delete Patient
            */
            iPatientService.deletePatient(1L);

        };


    }
}

