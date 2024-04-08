package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "boutique")
public class Boutique extends AbstractEntity {
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "siteweb")
    private String siteWeb;
    @Column(name = "photo")
    private String photo;

    @OneToOne
    private Vendeur vendeur;
    @OneToMany(mappedBy = "boutique")
    private List<Produit> produits;
    @OneToMany(mappedBy = "boutique")
    private List<Avis> avis;

}
