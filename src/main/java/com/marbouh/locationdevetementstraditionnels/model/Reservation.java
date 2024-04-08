package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "dateDebut")
    private String dateDebut;
    @Column(name = "dateFin")
    private String dateFin;
    @Column(name = "etat")
    private String etat;

    @ManyToOne
    private Client client;
    @OneToOne
    private CreneauEssayage creneauEssayage;
}
