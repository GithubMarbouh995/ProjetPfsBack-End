package com.marbouh.locationdevetementstraditionnels.services;

import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.model.Validation;

import java.util.Optional;

public interface ValidationService {

    public void enregistrer(Utilisateur utilisateur) ;
    public Optional<Validation> lireEnFonctionDuCode(String code) ;
}
