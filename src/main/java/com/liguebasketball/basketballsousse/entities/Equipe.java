package com.liguebasketball.basketballsousse.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor @NoArgsConstructor @ToString
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEquipe;


    @Column(unique = true,length = 50 ,nullable = false)
    private String nom;
    /*@Column
    private int nombreVictoire;

    @Column
    private int nombreVictoire;
    private nmb de point

    @Column
    private int matchJouer;

     @Column
    private int matchPerdue;
    */



    @Column
    private int matchJouerDomicile;

    @Column
    private int matchJouerExterieur;

    @Column
    private int pointMarquer;

    @Column
    private int pointEncaisses;

    @Column
    private String logo;



    @OneToMany(mappedBy = "equipe")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Player> player;



    public Long getIdEquipe() {
        return idEquipe;
    }

    public String getNom() {
        return nom;
    }

    public int getMatchJouerDomicile() {
        return matchJouerDomicile;
    }

    public int getMatchJouerExterieur() {
        return matchJouerExterieur;
    }

    public int getPointMarquer() {
        return pointMarquer;
    }

    public int getPointEncaisses() {
        return pointEncaisses;
    }

    public String getLogo() {
        return logo;
    }


    public Collection<Player> getPlayer() {
        return player;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMatchJouerDomicile(int matchJouerDomicile) {
        this.matchJouerDomicile = matchJouerDomicile;
    }

    public void setMatchJouerExterieur(int matchJouerExterieur) {
        this.matchJouerExterieur = matchJouerExterieur;
    }

    public void setPointMarquer(int pointMarquer) {
        this.pointMarquer = pointMarquer;
    }

    public void setPointEncaisses(int pointEncaisses) {
        this.pointEncaisses = pointEncaisses;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }



    @JsonIgnore
    public void setPlayer(Collection<Player> player) {
        this.player = player;
    }
}
