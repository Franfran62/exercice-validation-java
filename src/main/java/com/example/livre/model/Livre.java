package com.example.livre.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="titre")
    @NotBlank(message="Ce champs ne peut pas être vide")
    @Max(value=250, message="Ce champs ne peut dépasser 250 caractères")
    private String titre;

    @Column(name="annee_de_publication")
    @Max(value=2024, message="L'année de publication ne peut pas être dans le futur")
    @NotNull
    private int anneeDePublication;

    @ManyToOne
    @JoinColumn(name="auteur_id")
    @NotNull
    private Auteur auteur;

    @ManyToOne
    @JoinColumn(name="genre_id")
    @NotNull
    private Genre genre;
}
