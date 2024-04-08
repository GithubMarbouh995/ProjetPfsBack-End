package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "location")
public class Location extends AbstractEntity{
        @Column(name = "datedebut")
        private Instant datedebut;
        @Column(name = "datefin")
        private Instant datefin;
        @Column(name = "etat")
        private String etat;

        @ManyToOne
        private Client client;
        @ManyToOne
        private Produit produit;
}
