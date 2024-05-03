package com.marbouh.locationdevetementstraditionnels.model;


import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.model.Client;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Location extends AbstractEntity {
    private Instant datedebut;

    private Instant datefin;
    private String etat;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Produit produit;
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
}