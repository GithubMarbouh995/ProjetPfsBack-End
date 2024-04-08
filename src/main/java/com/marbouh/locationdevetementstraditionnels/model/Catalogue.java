package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catalogue")
public class Catalogue extends AbstractEntity{
    @Column(name = "nom")
    String nom;
    @Column(name = "description")
    String description;
    @Column(name = "categorie")
    String Categorie;

    @OneToMany(mappedBy = "catalogue")
    private List<Produit> produits;
}
