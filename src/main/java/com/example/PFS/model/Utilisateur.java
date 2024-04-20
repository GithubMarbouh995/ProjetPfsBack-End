//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
//@Table(name = "utilisateur")
//@DiscriminatorColumn(name = "type_utilisateur")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//public class Utilisateur extends AbstractEntity  {
//    @Column(name = "nom")
//    private String nom;
//    @Column(name = "prenom")
//    private String prenom;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "motdepasse")
//    private String motDePasse;
//    @Column(name = "telephone")
//    private String telephone;
//    @Embedded
//    private Adresse adresse;
//    @Enumerated(EnumType.STRING)
//    private Role role;
//    @OneToMany(mappedBy = "user")
//    private List<Token> tokens;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return motDePasse;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}