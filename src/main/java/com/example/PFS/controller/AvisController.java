package com.example.PFS.controller;

import com.example.PFS.model.Avis;
import com.example.PFS.model.Boutique;
import com.example.PFS.service.AvisService;
import com.example.PFS.service.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AvisController {
    AvisService avisService;
    BoutiqueService boutiqueService;

    @Autowired
    public AvisController(AvisService avisService, BoutiqueService boutiqueService) {
        this.avisService = avisService;
        this.boutiqueService = boutiqueService;
    }

    @GetMapping("/avis")
    List<Avis> getAll() {
        return avisService.findAll();
    }

    @GetMapping("/avis/")
    Avis getAvis(@RequestParam("id") int id) {
        return avisService.findById(id);
    }

    @GetMapping("/test/")
    void test() {
        for (Avis a : boutiqueService.findById(39).getAvis()) {
            System.out.println(a.getCommentaire());
        }
    }

    @PostMapping("/avis/create")
    void createAvis(@RequestBody Avis avis) {

        Boutique boutique = boutiqueService.findById(avis.getBoutique().getId().intValue());

        avisService.save(avis, boutique);
    }

    @PutMapping("/avis/update")
    void updateAvis(@RequestBody Avis avis) {
        try {
            if (avis.getId() == null) {
                throw new IllegalArgumentException("Aucun id");
            }
            avisService.update(avis.getId().intValue());

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/avis/delete")
    void delete(@RequestBody Avis avis) {

        avisService.delete(avisService.findById(avis.getId().intValue()),
                boutiqueService.findById(avis.getBoutique().getId().intValue()));

    }

}
