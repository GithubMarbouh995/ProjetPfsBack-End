package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Location;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import com.marbouh.locationdevetementstraditionnels.model.Client;
import com.marbouh.locationdevetementstraditionnels.services.impl.LocationService;
import com.marbouh.locationdevetementstraditionnels.services.impl.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    LocationService locationService;
    BoutiqueService boutiqueService;

    @Autowired
    public LocationController(LocationService locationService, BoutiqueService boutiqueService) {
        this.locationService = locationService;
        this.boutiqueService = boutiqueService;
    }

    @GetMapping("/location")
    List<Location> getAll() {
        return locationService.findAll();
    }

    @GetMapping("/location/")
    Location getLocation(@RequestParam("id") int id) {
        return locationService.findById(id);
    }

    @PostMapping("/location/create")
    void createLocation(@RequestBody Location location) {
        location.setId(0);
//        Boutique boutique = location.getBoutique();
//        Client client = location.getClient();
//        boutique.getLocation().add(location);
//        location.setBoutique(boutique);
//        location.setClient(client);

        locationService.saveOrUpdate(location);
    }

    @PutMapping("/location/update")
    void updateLocation(@RequestBody Location location) {
        locationService.saveOrUpdate(location);
    }

    @PostMapping("/location/delete")
    void delete(@RequestParam("id") int id) {
        locationService.deleteById(id);
    }
}
