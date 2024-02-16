package com.example.testXtensusBack.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;

    @NotBlank(message = "Le nom ne doit pas être vide")
    @Size(min = 3, max = 25, message = "Le nom doit avoir entre 3 et 25 caractères")
    private String nom;

    @NotBlank(message = "Le prénom ne doit pas être vide")
    @Size(min = 3, max = 25, message = "Le prénom doit avoir entre 3 et 25 caractères")
    private String prenom;

    @NotBlank(message = "Le numéro de téléphone ne doit pas être vide")
    @Size(min = 8, max = 25, message = "Le numéro de téléphone doit avoir entre 8 et 25 caractères")
    private String tel;

    @NotNull
    @Email(message = "L'adresse e-mail doit être valide")
    private String mail;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="gouvernement_id")
    @JsonIgnoreProperties("personnes")
    private Gouvernement gouvernement;
}
