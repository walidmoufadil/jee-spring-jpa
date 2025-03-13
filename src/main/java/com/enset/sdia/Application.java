package com.enset.sdia;

import com.enset.sdia.entity.Patient;
import com.enset.sdia.repository.IPatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx, IPatientRepo iPatientRepo) {
        return args -> {
            iPatientRepo.saveAll(
                    List.of(
                            Patient.builder()
                                    .name("John")
                                    .score(10)
                                    .malade(true)
                                    .dateNaissance(new Date())
                                    .build(),
                            Patient.builder()
                                    .name("Maria")
                                    .score(15)
                                    .malade(false)
                                    .dateNaissance(new Date())
                                    .build(),
                            Patient.builder()
                                    .name("Maria")
                                    .score(15)
                                    .malade(false)
                                    .dateNaissance(new Date())
                                    .build(),
                            Patient.builder()
                                    .name("Maria")
                                    .score(15)
                                    .malade(false)
                                    .dateNaissance(new Date())
                                    .build(),
                            Patient.builder()
                                    .name("Maria")
                                    .score(15)
                                    .malade(false)
                                    .dateNaissance(new Date())
                                    .build()

                    )
            );

            Page<Patient> patients = iPatientRepo.findAll(PageRequest.of(0,5));
            patients.forEach(System.out::println);
            System.out.println("==============================================================");

            Patient patient = iPatientRepo.findById((long) 1).orElse(null);

            if(patient != null) {
                patient.setMalade(true);
                iPatientRepo.save(patient);
            }

            iPatientRepo.findByNameContains("John").forEach(System.out::println);

            Page<Patient> patients1 = iPatientRepo.findByMalade(true,PageRequest.of(0,4));
            System.out.println("==============================================================");
            patients1.forEach(System.out::println);

            iPatientRepo.deleteById((long) 1);
        };

    }
}

