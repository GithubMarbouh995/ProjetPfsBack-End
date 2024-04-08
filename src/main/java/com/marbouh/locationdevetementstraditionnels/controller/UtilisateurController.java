package com.marbouh.locationdevetementstraditionnels.controller;
import com.marbouh.locationdevetementstraditionnels.dto.AuthentificationDTO;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.services.impl.UtilisateurServiceImpl;
import com.marbouh.locationdevetementstraditionnels.utils.JwtUtil;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(consumes = MediaType.APPLICATION_JSON)
public class UtilisateurController {

    private AuthenticationManager authenticationManager;
    private UtilisateurServiceImpl utilisateurService;
    private JwtUtil jwtService;

    @PostMapping(path = "inscription")
    public void inscription(@RequestBody Utilisateur utilisateur) {
        log.info("Inscription");
        this.utilisateurService.inscription(utilisateur);
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.utilisateurService.activation(activation);
    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );

        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }
        return null;
    }

}
