package com.example.PFS.controller;

import com.example.PFS.model.Boutique;
import com.example.PFS.service.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class BoutiqueController {
    BoutiqueService boutiqueService;

    @Autowired
    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping("/boutiques")
    List<Boutique> getAll() {
        return boutiqueService.findAll();
    }

    @GetMapping("/boutiques/")
    Boutique getBoutique(@RequestParam("id") int id) {
        return boutiqueService.findById(id);
    }

    @PostMapping("/boutiques/create")
    void createBoutique(@RequestBody Boutique boutique) {
        boutique.setId(0L);
        boutiqueService.saveOrUpdate(boutique);
    }

    @PutMapping("/boutiques/update")
    void updateBoutique(@RequestBody Boutique boutique) {
        boutiqueService.saveOrUpdate(boutique);
    }

    @PostMapping("/boutiques/delete")
    void delete(@RequestParam("id") int id) {
        boutiqueService.deleteById(id);
    }
}
