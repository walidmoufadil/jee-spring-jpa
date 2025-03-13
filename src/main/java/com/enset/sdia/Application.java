package com.enset.sdia;

import com.enset.sdia.entity.Patient;
import com.enset.sdia.repository.IPatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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
                                    .dateNaissance(new Date("01/01/1970"))
                                    .build(),
                            Patient.builder()
                                    .name("Maria")
                                    .score(15)
                                    .malade(false)
                                    .dateNaissance(new Date("02/02/1980"))
                                    .build()

                    )
            );

            iPatientRepo.findAll().forEach(System.out::println);

            iPatientRepo.findById((long) 1);

            iPatientRepo.findByNameContains("John").forEach(System.out::println);

            iPatientRepo.deleteById((long) 1);
        };

    }
}

