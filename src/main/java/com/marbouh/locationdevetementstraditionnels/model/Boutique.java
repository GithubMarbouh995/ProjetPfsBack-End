package com.marbouh.locationdevetementstraditionnels.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "boutique")
public class Boutique extends AbstractEntity {

    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    @OneToMany(mappedBy = "boutique",  fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL
//            CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH
    }
    )
    private List<Avis> avis = new ArrayList<>();
    @Column(name = "siteWeb")

    private String siteweb;
    private String horaire;
    @OneToOne
    @JoinColumn(name = "vendeur_id", referencedColumnName = "id")
    private Vendeur vendeur;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boutique" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Produit> produits;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="image_boutique", joinColumns = {@JoinColumn (name="id_boutique")} , inverseJoinColumns = {@JoinColumn ( name = "id_image")})
    private Set<Image> Images;

//    public List<Avis> getAvis() {
//        return avis;
//    }
//
//    public void setAvis(List<Avis> avis) {
//        this.avis = avis;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSiteweb() {
//        return siteweb;
//    }
//
//    public void setSiteweb(String siteweb) {
//        this.siteweb = siteweb;
//    }
//
//    public String getHoraire() {
//        return horaire;
//    }
//
//    public void setHoraire(String horaire) {
//        this.horaire = horaire;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


}