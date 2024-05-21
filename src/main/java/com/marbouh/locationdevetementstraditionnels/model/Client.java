package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CLIENT")
@Table(name = "client")
public class Client extends Utilisateur {
    private boolean blacklistee;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "client")
    private List<Avis> avis;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Location> locations;


}
