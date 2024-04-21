package com.example.PFS.controller;


import com.example.PFS.DAO.CreneauDisponibiliteDAO;
import com.example.PFS.model.CreneauDisponibilite;
import com.example.PFS.service.CreneauDisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreneauDisponibiliteController {

    @Autowired
    private CreneauDisponibiliteService creneauDisponibiliteService;
    @Autowired
    private CreneauDisponibiliteDAO creneauDisponibiliteDAO;

    @PostMapping("/ajouterCreneauProduit/{id_produit}/{id_creneau}")
    public CreneauDisponibilite ajouterCreneauProduit(@PathVariable Integer id_creneau, @PathVariable Integer id_produit) {
        return creneauDisponibiliteService.ajouterCreneauProduit(creneauDisponibiliteDAO.findById(id_creneau).get(), id_produit);
    }

    @PostMapping("/ajouterCreneau")
    public CreneauDisponibilite ajouterCreneau(@RequestBody CreneauDisponibilite creneauDisponibilite) {
        return creneauDisponibiliteService.ajouterCreneau(creneauDisponibilite);
    }
}
