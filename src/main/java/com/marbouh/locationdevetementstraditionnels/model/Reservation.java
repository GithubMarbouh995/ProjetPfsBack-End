package com.marbouh.locationdevetementstraditionnels.model;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "reservation")
public class Reservation extends AbstractEntity{
    private Instant date;
    private int produit_id;
    private boolean accepted;
    private int client_id;
    @ManyToOne(cascade = CascadeType.ALL)
    private CreneauEssayage creneauEssayage;

    public Reservation(Instant date, int produit_id, String client_id, boolean accepted) {
        this.date = date;
        this.produit_id = produit_id;
        this.accepted = accepted;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }


}
