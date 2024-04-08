package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "administrateur")
public class Administrateur extends Utilisateur{
     public void validerVendeur(Vendeur vendeur) {
     // TODO implement here
     }
     public void validerBlacklist(Client client) {
      // TODO implement here
        }
     public void supprimerVendeur(Vendeur vendeur) {
         // TODO implement here

        }

}
