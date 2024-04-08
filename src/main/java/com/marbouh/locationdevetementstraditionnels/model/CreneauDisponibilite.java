package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "creneau_disponibilite")
public class CreneauDisponibilite extends AbstractEntity{
    @Column(name = "datedebut")
    private Instant datedebut;
    @Column(name = "datefin")
    private Instant datefin;
    @ManyToOne
    private Produit produit;
}
