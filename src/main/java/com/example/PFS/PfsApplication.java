package com.example.PFS;

import com.example.PFS.DAO.BoutiqueRepository;
import com.example.PFS.model.Avis;
import com.example.PFS.service.BoutiqueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.example.PFS.model")
public class PfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfsApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(BoutiqueService boutiqueService) {
//
//        return runner -> {
//
//        };
//    }


}
