package com.example.livre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    @NotBlank(message="Ce champs ne peut pas être vide")
    private String nom;

    @Column(name="description")
    @NotBlank(message="Ce champs ne peut pas être vide")
    @Max(value=200, message="Ce champs ne peut dépasser 200 caractères")
    private String description;
}
