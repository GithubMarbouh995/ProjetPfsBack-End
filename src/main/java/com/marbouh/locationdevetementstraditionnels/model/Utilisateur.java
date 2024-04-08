package com.marbouh.locationdevetementstraditionnels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.marbouh.locationdevetementstraditionnels.model.Roles;
import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity implements UserDetails{
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "motdepasse")
    private String motDePasse;
    @Column(name = "telephone")
    private String telephone;
    @Embedded
    private Adresse adresse;
    private boolean actif = false;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.getRoleName()));
    }

    @Override
    public String getPassword() {

    return this.motDePasse;
    }

    @Override
    public String getUsername() {

    return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isEnabled() {
        return this.actif;
    }
}
