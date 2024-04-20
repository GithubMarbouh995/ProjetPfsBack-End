package com.example.PFS.DAO;

import com.example.PFS.model.Avis;
import com.example.PFS.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvisRepository extends JpaRepository<Avis,Integer> {
}
