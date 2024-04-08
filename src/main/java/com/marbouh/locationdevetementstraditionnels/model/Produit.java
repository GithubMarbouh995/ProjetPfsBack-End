package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "produit")
public class Produit extends AbstractEntity{
    @Column(name = "nom")
    String nom;
    @Column(name = "description")
    String description;
    @Column(name = "image")
    String image;
    @Column(name = "prixLocation")
    String prixLocation;
    @Column(name = "categorie")
    String categorie;
    @Column(name = "taille")
    String taille;

    @ManyToOne
    private Boutique boutique;
    @OneToMany(mappedBy = "produit")
    private List<CreneauDisponibilite> creneauxDisponibilites;
    @ManyToOne
    private Catalogue catalogue;
    @OneToMany(mappedBy = "produit")
    private List<Location> Locations;


}
