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
    private boolean accepted;;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Produit produit;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Client client;


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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}