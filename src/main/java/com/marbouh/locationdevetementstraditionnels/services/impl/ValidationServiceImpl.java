package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.model.Validation;
import com.marbouh.locationdevetementstraditionnels.repository.ValidationRepository;
import com.marbouh.locationdevetementstraditionnels.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;
@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private ValidationRepository validationRepository;

    public void enregistrer(Utilisateur utilisateur) {
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
        System.out.println("code = " + code);
        validation.setCode(code);
        this.validationRepository.save(validation);

    }
    public Optional<Validation> lireEnFonctionDuCode(String code) {
        return validationRepository.findByCode(code);
    }

//    public Validation lireEnFonctionDuCode(String code) {
//        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
//    }
}
