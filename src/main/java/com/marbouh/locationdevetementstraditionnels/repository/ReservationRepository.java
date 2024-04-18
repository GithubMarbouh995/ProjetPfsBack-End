package com.marbouh.locationdevetementstraditionnels.repository;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {



    @Query("UPDATE Reservation r SET r.status = 'VALIDE' WHERE r.client.id = ?1 AND r.produit.id = ?2")
    void validerReservation(int idUtilisateur, int idArticle);

    @Query("UPDATE Reservation r SET r.status = 'REFUSE' WHERE r.client.id = ?1 AND r.produit.id = ?2")
    void refuserReservation(int idUtilisateur, int idArticle);

    @Query("DELETE FROM Reservation r WHERE r.client.id = ?1 AND r.produit.id = ?2")
    void retirerReservation(int idUtilisateur, int idArticle);

    @Query("DELETE FROM Reservation r WHERE r.client.id = ?1")
    void retirerToutesReservations(int idUtilisateur);

    @Query("DELETE FROM Reservation r")
    void retirerToutesReservations();

    @Query("UPDATE Reservation r SET r.status = 'VALIDE'")
    void validerToutesReservations();

    @Query("UPDATE Reservation r SET r.status = 'REFUSE'")
    void refuserToutesReservations();

    @Query("DELETE FROM Reservation r WHERE r.status = 'VALIDE'")
    void retirerToutesReservationsValidees();

    @Query("DELETE FROM Reservation r WHERE r.status = 'REFUSE'")
    void retirerToutesReservationsRefusees();

    @Query("DELETE FROM Reservation r WHERE r.status = 'EN_ATTENTE'")
    void retirerToutesReservationsEnAttente();

    @Query("DELETE FROM Reservation r WHERE r.status = 'RETIRE'")
    void retirerToutesReservationsRetirees();
     @Query("SELECT r FROM Reservation r WHERE r.client.id = ?1")
    List<Reservation> getReservationsByUser(int idUtilisateur);
}
