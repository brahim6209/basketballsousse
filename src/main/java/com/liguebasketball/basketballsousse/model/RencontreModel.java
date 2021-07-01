package com.liguebasketball.basketballsousse.model;

import com.liguebasketball.basketballsousse.entities.Equipe;
import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Ligue;
import lombok.*;

import java.util.Date;


@Data

@ToString
@Builder
public class RencontreModel {

    private Date dateDuRencontre;

    private String lieuDuRentre;


    private Equipe idEquipe1;

    public RencontreModel() {
    }

    public Date getDateDuRencontre() {
        return dateDuRencontre;
    }

    public void setDateDuRencontre(Date dateDuRencontre) {
        this.dateDuRencontre = dateDuRencontre;
    }

    public String getLieuDuRentre() {
        return lieuDuRentre;
    }

    public void setLieuDuRentre(String lieuDuRentre) {
        this.lieuDuRentre = lieuDuRentre;
    }

    public Equipe getIdEquipe1() {
        return idEquipe1;
    }

    public void setIdEquipe1(Equipe idEquipe1) {
        this.idEquipe1 = idEquipe1;
    }

    public Equipe getIdEquipe2() {
        return idEquipe2;
    }

    public void setIdEquipe2(Equipe idEquipe2) {
        this.idEquipe2 = idEquipe2;
    }

    public Journee getIdJournee() {
        return idJournee;
    }

    public void setIdJournee(Journee idJournee) {
        this.idJournee = idJournee;
    }

    public Ligue getIdLigue() {
        return idLigue;
    }

    public void setIdLigue(Ligue idLigue) {
        this.idLigue = idLigue;
    }

    public RencontreModel(Date dateDuRencontre, String lieuDuRentre, Equipe idEquipe1, Equipe idEquipe2, Journee idJournee, Ligue idLigue) {
        this.dateDuRencontre = dateDuRencontre;
        this.lieuDuRentre = lieuDuRentre;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
        this.idLigue = idLigue;
    }

    private Equipe idEquipe2;


    private Journee idJournee;
     private Ligue idLigue;

}
