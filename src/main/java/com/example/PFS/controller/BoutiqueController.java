package com.example.PFS.controller;

import com.example.PFS.model.Boutique;
import com.example.PFS.service.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("api/boutiques")
public class BoutiqueController {
    BoutiqueService boutiqueService;

    @Autowired
    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping()
    List<Boutique> getAll() {
        return boutiqueService.findAll();
    }

    @GetMapping("/{id}")
    Boutique getBoutique(@RequestParam("id") int id) {
        return boutiqueService.findById(id);
    }

    @PostMapping()
    void createBoutique(@RequestBody Boutique boutique) {
        boutique.setId(0L);
        boutiqueService.saveOrUpdate(boutique);
    }

    @PutMapping()
    void updateBoutique(@RequestBody Boutique boutique) {
        System.out.println("hacho"+boutique.getId());
        boutiqueService.saveOrUpdate(boutique);
    }

    @DeleteMapping("/{id}")
    void delete(@RequestParam("id") int id) {
        boutiqueService.deleteById(id);
    }
}
