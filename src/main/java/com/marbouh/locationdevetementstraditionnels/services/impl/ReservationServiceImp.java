package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitRepository;
import com.marbouh.locationdevetementstraditionnels.repository.ReservationRepository;
import com.marbouh.locationdevetementstraditionnels.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.stereotype.Service;
import com.marbouh.locationdevetementstraditionnels.model.CreneauEssayage;
import com.marbouh.locationdevetementstraditionnels.repository.CreneauEssayageRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CreneauEssayageRepository creneauEssayageRepository;
    private final ProduitRepository produitRepository;

    public ReservationServiceImp(ReservationRepository reservationRepository, CreneauEssayageRepository creneauEssayageRepository, ProduitRepository produitRepository) {
        this.reservationRepository = reservationRepository;
        this.creneauEssayageRepository = creneauEssayageRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    @Transactional
    public void reserver(Reservation reservation) {
        CreneauEssayage creneauEssayage = reservation.getCreneauEssayage();
        // Si CreneauEssayage est une nouvelle instance ou une instance existante, sauvegardez-la avant de sauvegarder Reservation
        creneauEssayage = creneauEssayageRepository.save(creneauEssayage);
        reservation.setCreneauEssayage(creneauEssayage);

        // Faites de même pour Produit
        Produit produit = reservation.getProduit();
        produit = produitRepository.save(produit);
        reservation.setProduit(produit);

        reservationRepository.save(reservation);
    }
    @Override
    @Transactional
    public void modifierReservation(Reservation reservation) {

        Reservation existingReservation = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        existingReservation.setProduit(reservation.getProduit());
        existingReservation.setCreneauEssayage(reservation.getCreneauEssayage());
        existingReservation.setStatus(reservation.getStatus());
        existingReservation.setClient(reservation.getClient());
        existingReservation.setCode(reservation.getCode());
        existingReservation.setQuantite(reservation.getQuantite());
        existingReservation.setDateDebut(reservation.getDateDebut());
        existingReservation.setDateFin(reservation.getDateFin());
        existingReservation.setEtat(reservation.getEtat());

        reservationRepository.save(existingReservation);
    }

    @Override
    public void annulerReservation(int idReservation) {
        log.info("Annuler reservation: {}", idReservation);
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public void validerReservation(int idUtilisateur, int idArticle) {
        log.info("Valider reservation: utilisateur: {}, article: {}", idUtilisateur, idArticle);
        reservationRepository.validerReservation(idUtilisateur, idArticle);

    }

    @Override
    public void refuserReservation(int idUtilisateur, int idArticle) {
        log.info("Refuser reservation: utilisateur: {}, article: {}", idUtilisateur, idArticle);
        reservationRepository.refuserReservation(idUtilisateur, idArticle);
    }

    @Override
    public void retirerReservation(int idUtilisateur, int idArticle) {
        log.info("Retirer reservation: utilisateur: {}, article: {}", idUtilisateur, idArticle);
        reservationRepository.retirerReservation(idUtilisateur, idArticle);
    }

    @Override
    public void retirerToutesReservations(int idUtilisateur) {
        log.info("Retirer toutes les reservations de l'utilisateur: {}", idUtilisateur);
        reservationRepository.retirerToutesReservations(idUtilisateur);
    }

    @Override
    public void retirerToutesReservations() {
        log.info("Retirer toutes les reservations");
        reservationRepository.deleteAll();
    }

    @Override
    public void validerToutesReservations() {
        log.info("Valider toutes les reservations");
        reservationRepository.validerToutesReservations();
    }
    @Override
    public void refuserToutesReservations() {
        log.info("Refuser toutes les reservations");
        reservationRepository.refuserToutesReservations();
    }

    @Override
    public void retirerToutesReservationsValidees() {
        log.info("Retirer toutes les reservations validées");
        reservationRepository.retirerToutesReservationsValidees();
    }

    @Override
    public void retirerToutesReservationsRefusees() {

        log.info("Retirer toutes les reservations refusées");
        reservationRepository.retirerToutesReservationsRefusees();
    }

    @Override
    public void retirerToutesReservationsEnAttente() {
        log.info("Retirer toutes les reservations en attente");
        reservationRepository.retirerToutesReservationsEnAttente();
    }

    @Override
    public void retirerToutesReservationsRetirees() {
        log.info("Retirer toutes les reservations retirées");
        reservationRepository.retirerToutesReservationsRetirees();
    }

    @Override
    public List<Reservation> getReservationsByUser(int idUtilisateur) {
        log.info("Get reservations by user: {}", idUtilisateur);
        return reservationRepository.getReservationsByUser(idUtilisateur);
    }

    @Override
    public List<Reservation> getReservations() {
        log.info("Get all reservations");
        return reservationRepository.findAll();
    }
}
