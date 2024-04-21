package com.example.PFS.DAO;

import com.example.PFS.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDAO extends CrudRepository<Produit,Integer> {}

