package com.liguebasketball.basketballsousse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;


@Entity

@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Ligue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLigue;

    @Column
    private String nomLigue;

    public Long getIdLigue() {
        return idLigue;
    }

    public void setIdLigue(Long idLigue) {
        this.idLigue = idLigue;
    }

    public String getNomLigue() {
        return nomLigue;
    }

    public void setNomLigue(String nomLigue) {
        this.nomLigue = nomLigue;
    }

    public Collection<Journee> getJournee() {
        return journee;
    }
@JsonIgnore
    public void setJournee(Collection<Journee> journee) {
        this.journee = journee;
    }

    public Collection<Rencontre> getRencontre() {
        return rencontre;
    }
 @JsonIgnore
    public void setRencontre(Collection<Rencontre> rencontre) {
        this.rencontre = rencontre;
    }

    public Collection<Player> getPlayer() {
        return player;
    }

    @JsonIgnore
    public void setPlayer(Collection<Player> player) {
        this.player = player;
    }

    @OneToMany(mappedBy = "ligue")
    private Collection<Journee> journee;

@OneToMany(mappedBy = "ligue")
    private Collection<Rencontre> rencontre;

    @OneToMany(mappedBy = "ligue")
    private Collection<Player> player ;

}
