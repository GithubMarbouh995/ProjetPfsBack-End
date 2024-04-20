package com.example.PFS.controller;

import com.example.PFS.model.Avis;
import com.example.PFS.model.Boutique;
import com.example.PFS.model.Client;
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
        avis.setId(0L);
        Boutique boutique = avis.getBoutique();
        Client client = avis.getClient();
        boutique.getAvis().add(avis);
//        client.
        avis.setBoutique(boutique);
        avis.setClient(client);

        avisService.saveOrUpdate(avis);
    }

    @PutMapping("/avis/update")
    void updateAvis(@RequestBody Avis avis) {
        avisService.saveOrUpdate(avis);
    }

    @PostMapping("/avis/delete")
    void delete(@RequestParam("id") int id) {
        avisService.deleteById(id);
    }
}
