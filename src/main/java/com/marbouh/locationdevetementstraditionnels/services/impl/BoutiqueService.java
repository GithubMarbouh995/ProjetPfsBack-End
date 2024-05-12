package com.marbouh.locationdevetementstraditionnels.services.impl;

import com.marbouh.locationdevetementstraditionnels.model.Catalogue;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.repository.BoutiqueRepository;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoutiqueService {
    BoutiqueRepository boutiqueRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    public ArrayList<Boutique> findAll() {
        return new ArrayList<>(boutiqueRepository.findAll());
    }

    public Boutique findById(int id) {
        Optional<Boutique> boutique = boutiqueRepository.findById(id);
        return boutique.orElse(null);
    }

    public void saveOrUpdate(Boutique boutique) {
        boutiqueRepository.save(boutique);
    }

    public void deleteById(int id) {
        boutiqueRepository.deleteById(id);
    }

    public List getAllProduitsFromBoutique(Integer id_boutique) {
        Boutique boutique = boutiqueRepository.findById(id_boutique).get();
        return boutique.getProduits();
    }

}
