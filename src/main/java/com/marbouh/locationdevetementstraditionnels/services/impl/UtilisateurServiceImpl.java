package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.dto.ChangerMotDePasseUtilisateurDto;
import com.marbouh.locationdevetementstraditionnels.dto.UtilisateurDto;
import com.marbouh.locationdevetementstraditionnels.exception.ErrorCodes;
import com.marbouh.locationdevetementstraditionnels.exception.InvalidEntityException;
import com.marbouh.locationdevetementstraditionnels.exception.InvalidOperationException;
import com.marbouh.locationdevetementstraditionnels.model.Roles;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.repository.RolesRepository;
import com.marbouh.locationdevetementstraditionnels.repository.UtilisateurRepository;
import com.marbouh.locationdevetementstraditionnels.services.UtilisateurService;
import com.marbouh.locationdevetementstraditionnels.services.ValidationService;
import com.marbouh.locationdevetementstraditionnels.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.marbouh.locationdevetementstraditionnels.model.Validation;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {
    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private RolesRepository roleRepository;


    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository,
                                  PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));

        }
        if (userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }
        dto.setMoteDePasse(passwordEncoder.encode(dto.getMoteDePasse()));
       return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto)
                )
        );
    }
    private boolean userAlreadyExists(String email) {
    Optional<Utilisateur> utilisateur=utilisateurRepository.findUtilisateurByEmail(email);
    return utilisateur.isPresent();
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new InvalidEntityException(
                        "Aucun utilisateur avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
if (id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);

    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findUtilisateurByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new InvalidEntityException(
                        "Aucun utilisateur avec l'email = " + email + " n'ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );


}
@Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        validate(dto);
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(dto.getId());
        if (utilisateur.isEmpty()) {
            log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId());
            throw new InvalidEntityException("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId(), ErrorCodes.UTILISATEUR_NOT_FOUND);
        }
        Utilisateur utilisateur1 = utilisateur.get();
        utilisateur1.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(utilisateur1)
        );
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return utilisateurRepository.findUtilisateurByEmail(username)
                .orElseThrow(() -> new InvalidEntityException(
                        "Aucun utilisateur avec l'email = " + username + " n'ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    private void validate(ChangerMotDePasseUtilisateurDto dto) {
        if (dto == null) {
            log.warn("Impossible de changer le mot de passe de l'utilisateur, changerMotDePasseUtilisateurDto is null");
            throw new InvalidEntityException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getId() == null) {
            log.warn("Impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalidEntityException("ID utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
            throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }

    public void inscription(Utilisateur utilisateur) {

        // Vérifiez si l'email est valide
        if(!utilisateur.getEmail().contains("@") || !utilisateur.getEmail().contains(".")) {
            throw  new RuntimeException("Votre mail invalide");
        }

        // Vérifiez si l'email est déjà utilisé
        Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findUtilisateurByEmail(utilisateur.getEmail());
        if(utilisateurOptional.isPresent()) {
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }

        // Vérifiez si le mot de passe est null
        if(utilisateur.getMotDePasse() == null) {
            throw new RuntimeException("Le mot de passe ne peut pas être null");
        }

        // Encodez le mot de passe
        String mdpCrypte = this.passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(mdpCrypte);

//        Roles roleUtilisateur = new Roles();
//        roleUtilisateur.setRoleName("UTILISATEUR");
//        utilisateur.setRole(roleUtilisateur);
//         Récupérez le rôle de la base de données
        Roles roleUtilisateur = roleRepository.findByName("UTILISATEUR")
                .orElseThrow(() -> new RuntimeException("Erreur : Le rôle n'a pas été trouvé."));
        utilisateur.setRole(roleUtilisateur);

        utilisateur = this.utilisateurRepository.save(utilisateur);
        this.validationService.enregistrer(utilisateur);
    }

    public void activation(Map<String, String> activation) {
        Optional<Validation> validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.get().getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        Utilisateur utilisateurActiver = validation.get().getUtilisateur();
        utilisateurActiver.setActif(true);
        this.utilisateurRepository.save(utilisateurActiver);
    }


}
