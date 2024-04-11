package com.example.PFS.controller;

import com.example.PFS.DAO.ProduitDAO;
import com.example.PFS.model.Image;
import com.example.PFS.model.Produit;
import com.example.PFS.service.ProduitService;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitDAO produitDAO;

    @PostMapping(value = {"/ajouterProduit"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Produit ajouterProduit(@RequestPart("produit") Produit produit, @RequestPart("image_produit")MultipartFile[] files ) {
        try {
           Set<Image> images = uploadImage(files);
           produit.setImages(images);
           return produitService.ajouterProduit(produit);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping({"/getAllProduits"})
    public List<Produit> getAllProduits() {
          return produitService.getAllProduits();
    }

    @DeleteMapping({"/supprimerProduit/{ProduitId}"})
    public void supprimerProduit(@PathVariable("ProduitId") Integer ProduitId) {
            produitService.supprimerProduit(ProduitId);
    }

    @PutMapping({"/updateProduit/{ProduitId}"})
    public Produit updateProduit(@PathVariable("ProduitId") Integer ProduitId, @RequestBody Produit produit) {
              return produitService.updateProduit(ProduitId,produit);
    }

    public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Image> images = new HashSet<>();
        for(MultipartFile fichier : multipartFiles){
            Image image = new Image(
                    fichier.getName(), fichier.getContentType(), fichier.getBytes());
            images.add(image);
        }
        return images;
    }
}
