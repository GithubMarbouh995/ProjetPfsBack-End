package com.marbouh.locationdevetementstraditionnels.model;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
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
    @Column(name = "status")
    private String status;
    @Column(name = "quantite")
    private int quantite;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produit produit;
    @ManyToOne
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    private CreneauEssayage creneauEssayage;
}
