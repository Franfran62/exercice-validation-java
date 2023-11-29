package com.example.livre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    @NotBlank(message="Ce champs ne peut pas être vide")
    @Max(value=50, message="Ce champs ne peut dépasser 50 caractères")
    private String nom;

    @Column(name="email")
    @NotBlank(message="Ce champs ne peut pas être vide")
    @Email(message="L'adresse n'est pas valide")
    private String email;
}
