package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avis")
public class Avis extends AbstractEntity{

    @Column(name = "note")
    private int note;
    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Boutique boutique;

}
