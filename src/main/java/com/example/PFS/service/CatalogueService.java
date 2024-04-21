package com.example.PFS.service;

import com.example.PFS.DAO.CatalogueDAO;
import com.example.PFS.DAO.ProduitDAO;
import com.example.PFS.model.Catalogue;
import com.example.PFS.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    @Autowired
    private CatalogueDAO catalogueDAO;
    @Autowired
    private ProduitDAO produitDAO;
    public Catalogue ajouterCatalogue(Catalogue catalogue){
        return catalogueDAO.save(catalogue);
    }
    public Iterable<Catalogue> getAllCatalogues() {
        return catalogueDAO.findAll();
    }
    public void supprimerCatalogue(Integer id_catalogue) {
        catalogueDAO.deleteById(id_catalogue);
    }
    public void ajouterProduitToCatalogue(Integer id_catalogue, Integer id_produit) {
        Catalogue catalogue = catalogueDAO.findById(id_catalogue).get();
        catalogue.getProduits().add(produitDAO.findById(id_produit).get());
        Produit produit = produitDAO.findById(id_produit).get();
        produit.setCatalogue(catalogue);
        catalogueDAO.save(catalogue);
    }
    public List getAllProduitsFromCatalogue(Integer id_catalogue) {
        Catalogue catalogue = catalogueDAO.findById(id_catalogue).get();
        return catalogue.getProduits();
    }
}
