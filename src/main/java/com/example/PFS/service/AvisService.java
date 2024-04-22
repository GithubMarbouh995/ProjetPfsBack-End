package com.example.PFS.service;

import com.example.PFS.DAO.AvisRepository;
import com.example.PFS.model.Avis;
import com.example.PFS.model.Boutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public void saveOrUpdate(Avis avis, Boutique boutique) {
        try {

            if (boutique != null) {
                List<Avis> BoutiqueAvisList = boutique.getAvis();
                if (!BoutiqueAvisList.contains(avis)) {
                    BoutiqueAvisList.add(avis);
                    boutique.setAvis(BoutiqueAvisList);
                    avis.setBoutique(boutique);

                }

                avisRepository.save(avis);
            } else System.out.println("Wa chriif ra la boutique makinach asslan");

        } catch (Exception e) {
            e.printStackTrace();

            //Client client = boutiqueService.findById(avis.getBoutique().getId().intValue());
//avis.getClient().getAvis().add(avis);

        }
    }

    public void deleteById(int id) {
        avisRepository.deleteById(id);
    }

    public void delete(Avis avis) {
        avisRepository.delete(avis);
    }

}

