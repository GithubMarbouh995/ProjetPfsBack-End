package com.example.PFS.service;

import com.example.PFS.DAO.LocationRepository;
import com.example.PFS.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public ArrayList<Location> findAll() {
        return new ArrayList<>(locationRepository.findAll());
    }

    public Location findById(int id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.orElse(null);
    }

    public void saveOrUpdate(Location location) {
        locationRepository.save(location);
    }

    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }

}

