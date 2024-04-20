package com.example.PFS.service;

import com.example.PFS.DAO.AvisRepository;
import com.example.PFS.model.Avis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AvisService {
    AvisRepository avisRepository;

    @Autowired
    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    public ArrayList<Avis> findAll() {
        return new ArrayList<>(avisRepository.findAll());
    }

    public Avis findById(int id) {
        Optional<Avis> avis = avisRepository.findById(id);
        return avis.orElse(null);
    }

    public void saveOrUpdate(Avis avis) {
        avisRepository.save(avis);
    }

    public void deleteById(int id) {
        avisRepository.deleteById(id);
    }

}

