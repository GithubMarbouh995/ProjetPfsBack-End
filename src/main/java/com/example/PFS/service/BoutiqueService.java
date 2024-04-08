package com.example.PFS.service;

import com.example.PFS.DAO.BoutiqueRepository;
import com.example.PFS.model.Boutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BoutiqueService {
    BoutiqueRepository boutiqueRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    ArrayList<Boutique> findAll() {
        return new ArrayList<>(boutiqueRepository.findAll());
    }

    Boutique findById(int id) {
        Optional<Boutique> boutique = boutiqueRepository.findById(id);
        return boutique.orElse(null);
    }

    void save(Boutique boutique) {
        boutiqueRepository.save(boutique);
    }



    void deleteById(int id) {
        boutiqueRepository.deleteById(id);
    }

}
