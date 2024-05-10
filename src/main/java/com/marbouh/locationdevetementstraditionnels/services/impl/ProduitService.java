package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.model.CreneauDisponibilite;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.repository.CreneauDisponibiliteDAO;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;
    @Autowired
    private CreneauDisponibiliteDAO creneauDisponibiliteDAO;

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
    public Set<Produit> getProduitsDispoPourCreneau(Integer id_creneau) {
        CreneauDisponibilite creneauDisponibilite = creneauDisponibiliteDAO.findById(id_creneau).get();
        return creneauDisponibilite.getProduits();
    }

    public Set<CreneauDisponibilite> getCreneauxPourProduit(Integer id_produit) {
        Produit produit = produitDAO.findById(id_produit).get();
        return produit.getCreneauDisponibilites();
    }
}
