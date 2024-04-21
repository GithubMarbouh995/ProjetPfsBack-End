package com.example.PFS.service;

import com.example.PFS.DAO.CreneauDisponibiliteDAO;
import com.example.PFS.DAO.ProduitDAO;
import com.example.PFS.model.CreneauDisponibilite;
import com.example.PFS.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreneauDisponibiliteService {

    @Autowired
    private CreneauDisponibiliteDAO creneauDisponibiliteDAO;
    @Autowired
    private ProduitDAO produitDAO;

    public CreneauDisponibilite ajouterCreneauProduit(CreneauDisponibilite creneauDisponibilite, Integer id_produit){
        Produit produit = produitDAO.findById(id_produit).get();
        creneauDisponibilite.getProduits().add(produit);
        return creneauDisponibiliteDAO.save(creneauDisponibilite);
    }

    public CreneauDisponibilite ajouterCreneau(CreneauDisponibilite creneauDisponibilite){
        return creneauDisponibiliteDAO.save(creneauDisponibilite);
    }


}
