package com.marbouh.locationdevetementstraditionnels.model;


import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.model.Client;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "location")
public class Location extends AbstractEntity {
    private Instant datedebut;
    private Instant datefin;
    private String etat;
    private int produit_id;
    private int client_id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }

    public Instant getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Instant datedebut) {
        this.datedebut = datedebut;
    }

    public Instant getDatefin() {
        return datefin;
    }

    public void setDatefin(Instant datefin) {
        this.datefin = datefin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
}