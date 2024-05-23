package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(@Param("email") String email);
    @Query("SELECT u.id FROM Utilisateur u WHERE u.email = :email")
    public int findIdByEmail(@Param("email") String email);
    @Query("SELECT u FROM Utilisateur u WHERE u.id = :id")
    public Utilisateur findbyId(int id);

}
