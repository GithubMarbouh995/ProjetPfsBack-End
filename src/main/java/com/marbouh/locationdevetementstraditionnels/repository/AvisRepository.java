package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Avis;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvisRepository extends JpaRepository<Avis,Integer> {
}
