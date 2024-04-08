package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "validation")
public class Validation extends AbstractEntity {
    private Instant creation;
    private Instant expiration;
    private Instant activation;
    private String code;
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;
}
