package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import com.marbouh.locationdevetementstraditionnels.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public void addReservation(@RequestBody Reservation reservation) {
        // TODO: Add input validation
        reservationService.reserver(reservation);
    }

    @PutMapping("/update")
    public void updateReservation(@RequestBody Reservation reservation) {
        // TODO: Add input validation
        reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable int idReservation) {
        // TODO: Add input validation
        reservationService.annulerReservation(idReservation);
    }

    @PutMapping("/validate/{idUtilisateur}/{idArticle}")
    public void validateReservation(@PathVariable int idUtilisateur, @PathVariable int idArticle) {
        // TODO: Add input validation
        reservationService.validerReservation(idUtilisateur, idArticle);
    }

    @PutMapping("/reject/{idUtilisateur}/{idArticle}")
    public void rejectReservation(@PathVariable int idUtilisateur, @PathVariable int idArticle) {
        // TODO: Add input validation
        reservationService.refuserReservation(idUtilisateur, idArticle);
    }

    @PutMapping("/withdraw/{idUtilisateur}/{idArticle}")
    public void withdrawReservation(@PathVariable int idUtilisateur, @PathVariable int idArticle) {
        // TODO: Add input validation
        reservationService.retirerReservation(idUtilisateur, idArticle);
    }

    @PutMapping("/withdraw-all/{id}")
    public void withdrawAllReservations(@PathVariable int id) {
        // TODO: Add input validation
        reservationService.retirerToutesReservations(id);
    }

    @PutMapping("/validate-all")
    public void validateAllReservations() {
        reservationService.validerToutesReservations();
    }

    @DeleteMapping("/delete-all")
    public void deleteAllReservations() {
        reservationService.retirerToutesReservations();
    }

    @GetMapping("/all-reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getReservations();
    }
}