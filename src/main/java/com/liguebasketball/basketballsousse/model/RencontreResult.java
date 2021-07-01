package com.liguebasketball.basketballsousse.model;


import com.liguebasketball.basketballsousse.entities.Arbitre;
import com.liguebasketball.basketballsousse.entities.Equipe;
import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Ligue;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class RencontreResult implements Serializable {




    private Date dateDuRencontre;

    private String lieuDuRencontre;

    public RencontreResult() {

    }

    public Date getDateDuRencontre() {
        return dateDuRencontre;
    }

    public void setDateDuRencontre(Date dateDuMatch) {
        this.dateDuRencontre = dateDuRencontre;
    }

        public String getLieuDuRencontre() {
        return lieuDuRencontre;
    }

    public void setLieuDuRencontre(String lieuDuDuRencontre) {
        this.lieuDuRencontre = lieuDuRencontre;
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

    private Equipe idEquipe1;


   private Ligue idLigue;

    public Ligue getIdLigue() {
        return idLigue;
    }

    public void setIdLigue(Ligue idLigue) {
        this.idLigue = idLigue;
    }

    public RencontreResult(Date dateDuRencontre, String lieuDuRencontre, Equipe idEquipe1, Ligue idLigue, Equipe idEquipe2, Journee idJournee, Arbitre idArbitre) {
        this.dateDuRencontre = dateDuRencontre;
        this.lieuDuRencontre = lieuDuRencontre;
        this.idEquipe1 = idEquipe1;
        this.idLigue = idLigue;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
        this.idArbitre = idArbitre;
    }

    private Equipe idEquipe2;
private  Journee idJournee;

    public Journee getIdJournee() {
        return idJournee;
    }

    public void setIdJournee(Journee idJournee) {
        this.idJournee = idJournee;
    }

    public Arbitre getIdArbitre() {
        return idArbitre;
    }

    public void setIdArbitre(Arbitre idArbitre) {
        this.idArbitre = idArbitre;
    }

    private Arbitre idArbitre;
}


