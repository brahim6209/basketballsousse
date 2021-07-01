package com.liguebasketball.basketballsousse.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity

@AllArgsConstructor @NoArgsConstructor @ToString
public class Player {
    public Long getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(Long idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNumeroLicence() {
        return numeroLicence;
    }

    public void setNumeroLicence(String numeroLicence) {
        this.numeroLicence = numeroLicence;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Ligue getLigue() {
        return ligue;
    }

    public void setLigue(Ligue ligue) {
        this.ligue = ligue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJoueur;

    @Column(unique = true,nullable = false , length = 55)
    private String matricule;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String dateNaissance;




    @Column
    private String nationnalite;

    @Column
    private String photo;



    @Column
    private String numeroLicence;


    @ManyToOne
   private Equipe equipe;

    @ManyToOne
    private Ligue ligue;
   
}
