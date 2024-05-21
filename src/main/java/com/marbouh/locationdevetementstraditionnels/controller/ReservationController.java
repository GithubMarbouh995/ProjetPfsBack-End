package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Location;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import com.marbouh.locationdevetementstraditionnels.services.ReservationService;
import com.marbouh.locationdevetementstraditionnels.services.impl.ReservationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReservationController {
    @Autowired
    private ReservationServiceImp reservationService;

    @GetMapping("/reservation")
    List<Reservation> getAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservation/")
    Reservation getReservation(@RequestParam("id") int id) {
        return reservationService.findById(id);
    }

    @PostMapping("/reservation/create")
    Reservation createLocation(@RequestBody Reservation reservation) {
        reservationService.saveOrUpdate(reservation);
        return(reservation);

    }

    @PutMapping("/reservation/update")
    void updateLocation(@RequestBody Reservation reservation) {
        reservationService.saveOrUpdate(reservation);
    }

    @PostMapping("/reservation/delete")
    void delete(@RequestParam("id") int id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/reservation/produit/{id}")
    List<Reservation> findByProduit_id(@PathVariable("id") int id) {
        return reservationService.findByProduit_id(id);
    }

    @GetMapping("/reservation/verify")
    List<Reservation> findByProduitAndPeriod(@RequestParam("produit_id") int produit_id, @RequestParam("date") Instant date) {
        return reservationService.findByProduitAndPeriod(produit_id, date);
    }

    @GetMapping("/reservation/verify_2")
    List<Location> verify_2(@RequestParam("produit_id") int produit_id, @RequestParam("date") Instant date) {
        return reservationService.verify_2(produit_id, date );
    }
}