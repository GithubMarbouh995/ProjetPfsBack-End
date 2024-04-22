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

    @PostMapping("/avis/create")
    void createAvis(@RequestBody Avis avis) {

        Boutique boutique = boutiqueService.findById(avis.getBoutique().getId().intValue());

        avisService.saveOrUpdate(avis, boutique);
    }

    @PutMapping("/avis/update")
    void updateAvis(@RequestBody Avis avis) {
        Boutique boutique = boutiqueService.findById(avis.getBoutique().getId().intValue());
        System.out.println("CHOF");
        System.out.println(avis.getId());
        System.out.println(avis.getCommentaire());
        avisService.saveOrUpdate(avis, boutique);
    }

    @DeleteMapping("/avis/delete")
    void delete(@RequestBody int id) {
        avisService.deleteById(id);
    }
}
