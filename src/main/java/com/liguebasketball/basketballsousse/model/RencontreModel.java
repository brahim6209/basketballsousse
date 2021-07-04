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
private  Long idRencontre;

private  int resultatEquipe1;

    public int getResultatEquipe1() {
        return resultatEquipe1;
    }

    public void setResultatEquipe1(int resultatEquipe1) {
        this.resultatEquipe1 = resultatEquipe1;
    }

    public int getResultatEquipe2() {
        return resultatEquipe2;
    }

    public void setResultatEquipe2(int resultatEquipe2) {
        this.resultatEquipe2 = resultatEquipe2;
    }

    private  int resultatEquipe2;

    public Long getIdRencontre() {
        return idRencontre;
    }

    public void setIdRencontre(Long idRencontre) {
        this.idRencontre = idRencontre;
    }



    private Date dateDuRencontre;

    public String getLieuDuRencontre() {
        return lieuDuRencontre;
    }

    public RencontreModel(Long idRencontre, int resultatEquipe1, int resultatEquipe2, Date dateDuRencontre, String lieuDuRencontre, Equipe idEquipe1, Equipe idEquipe2, Journee idJournee, Ligue idLigue) {
        this.idRencontre = idRencontre;
        this.resultatEquipe1 = resultatEquipe1;
        this.resultatEquipe2 = resultatEquipe2;
        this.dateDuRencontre = dateDuRencontre;
        this.lieuDuRencontre = lieuDuRencontre;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
        this.idLigue = idLigue;
    }

    public void setLieuDuRencontre(String lieuDuRencontre) {
        this.lieuDuRencontre = lieuDuRencontre;
    }

    private String lieuDuRencontre;


    private Equipe idEquipe1;

    public RencontreModel() {
    }

    public Date getDateDuRencontre() {
        return dateDuRencontre;
    }

    public void setDateDuRencontre(Date dateDuRencontre) {
        this.dateDuRencontre = dateDuRencontre;
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

    private Equipe idEquipe2;


    private Journee idJournee;
     private Ligue idLigue;

}
