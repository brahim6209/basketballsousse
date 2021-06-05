package com.liguebasketball.basketballsousse.model;


import com.liguebasketball.basketballsousse.entities.Equipe;
import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Ligue;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


public class RencontreResult implements Serializable {

    private Date dateDuMatch;

    private String lieuDuMatch;


    private Equipe idEquipe1;


    private Equipe idEquipe2;

    public  RencontreResult(){

    }
    public RencontreResult(Date dateDuMatch, String lieuDuMatch, Equipe idEquipe1, Equipe idEquipe2, Journee idJournee) {
        this.dateDuMatch = dateDuMatch;
        this.lieuDuMatch = lieuDuMatch;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
    }

    private Journee idJournee;

    private Ligue idLigue;

    public RencontreResult(Date dateDuMatch, String lieuDuMatch, Equipe idEquipe1, Equipe idEquipe2, Journee idJournee, Ligue idLigue) {
        this.dateDuMatch = dateDuMatch;
        this.lieuDuMatch = lieuDuMatch;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
        this.idLigue = idLigue;
    }

    public Date getDateDuMatch() {
        return dateDuMatch;
    }

    public String getLieuDuMatch() {
        return lieuDuMatch;
    }

    public Equipe getIdEquipe1() {
        return idEquipe1;
    }

    public Equipe getIdEquipe2() {
        return idEquipe2;
    }

    public Journee getIdJournee() {
        return idJournee;
    }

    public Ligue getIdLigue() {
        return idLigue;
    }

    public void setDateDuMatch(Date dateDuMatch) {
        this.dateDuMatch = dateDuMatch;
    }

    public void setLieuDuMatch(String lieuDuMatch) {
        this.lieuDuMatch = lieuDuMatch;
    }

    public void setIdEquipe1(Equipe idEquipe1) {
        this.idEquipe1 = idEquipe1;
    }

    public void setIdEquipe2(Equipe idEquipe2) {
        this.idEquipe2 = idEquipe2;
    }

    public void setIdJournee(Journee idJournee) {
        this.idJournee = idJournee;
    }

    public void setIdLigue(Ligue idLigue) {
        this.idLigue = idLigue;
    }
}


