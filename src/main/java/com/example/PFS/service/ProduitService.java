package com.example.PFS.service;

import com.example.PFS.DAO.ProduitDAO;
import com.example.PFS.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;
    public Produit ajouterProduit(Produit produit){
        return produitDAO.save(produit);
    }
    public List<Produit> getAllProduits() {
        return (List<Produit>) produitDAO.findAll();
    }
    public void supprimerProduit(Integer id_produit) {
        produitDAO.deleteById(id_produit);
    }
    public Produit updateProduit(Integer ProduitId,Produit produit) {
           Optional<Produit> ProduitExistant = produitDAO.findById(ProduitId);
           Produit Produit = ProduitExistant.get();
           Produit.setNom(produit.getNom());
           Produit.setDescription(produit.getDescription());
           Produit.setCategorie(produit.getCategorie());
           return produitDAO.save(Produit);
    }
}
