package com.marbouh.locationdevetementstraditionnels.services.impl;

import com.marbouh.locationdevetementstraditionnels.repository.BoutiqueRepository;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import com.marbouh.locationdevetementstraditionnels.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoutiqueService {
    BoutiqueRepository boutiqueRepository;
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepository boutiqueRepository,UtilisateurRepository utilisateurRepository) {
        this.boutiqueRepository = boutiqueRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public ArrayList<Boutique> findAll() {
        return new ArrayList<>(boutiqueRepository.findAll());
    }

    public Boutique findById(int id) {
        Optional<Boutique> boutique = boutiqueRepository.findById(id);
        return boutique.orElse(null);
    }

    public void saveOrUpdate(Boutique boutique) {
        utilisateurRepository.save(boutique.getVendeur());
        if (boutique.getId() == null) {
            Boutique boutique1 = new Boutique(boutique.getNom(), boutique.getAdresse(), boutique.getTelephone(), boutique.getEmail(), boutique.getSiteweb(), boutique.getHoraire(), boutique.getVendeur());
            boutiqueRepository.save(boutique1);
        }else{
            boutiqueRepository.saveAndFlush(boutique);
        }
    }

    public void deleteById(int id) {
        boutiqueRepository.deleteById(id);
    }

    public List getAllProduitsFromBoutique(Integer id_boutique) {
        Boutique boutique = boutiqueRepository.findById(id_boutique).get();
        return boutique.getProduits();
    }

}
