package com.marbouh.locationdevetementstraditionnels.repository;
import com.marbouh.locationdevetementstraditionnels.model.Location;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT l FROM Reservation l WHERE l.produit_id = :id")
    List<Reservation> findByProduit_id(int id);
    @Query("SELECT l FROM Reservation l WHERE l.produit_id = :produit_id  AND l.date= :date")
    List<Reservation> findByProduitAndPeriod(@Param("produit_id") int produit_id, @Param("date") Instant date);
    @Query("SELECT l FROM Location l WHERE l.produit_id= :produit_id  AND ( :date BETWEEN l.datedebut AND l.datefin)")
    List<Location> verify_2(@Param("produit_id") int produit_id, @Param("date") Instant date);

}
