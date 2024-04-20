package com.example.PFS.model;

import com.example.PFS.model.Client;
import com.example.PFS.model.Produit;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Location {
    private Instant datedebut;

    private Instant datefin;
    private String etat;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Produit produit;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}