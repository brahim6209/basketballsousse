package com.liguebasketball.basketballsousse.model;

import com.liguebasketball.basketballsousse.entities.Arbitre;
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
    private Equipe idEquipe1;


    private Equipe idEquipe2;


    private Journee idJournee;
    private Ligue idLigue;
    private Arbitre idArbitre;
    private int gagnante;

    public Arbitre getIdArbitre() {
        return idArbitre;
    }

    public void setIdArbitre(Arbitre idArbitre) {
        this.idArbitre = idArbitre;
    }

    private  int resultatEquipe1;
private  int resultatEquipe2;
    private Date dateDuRencontre;
    private String lieuDuRencontre;



    public Long getIdRencontre() {
        return idRencontre;
    }

    public void setIdRencontre(Long idRencontre) {
        this.idRencontre = idRencontre;
    }


    public String getLieuDuRencontre() {
        return lieuDuRencontre;
    }

    public RencontreModel(Long idRencontre, Equipe idEquipe1, Equipe idEquipe2, Journee idJournee, Ligue idLigue, Arbitre idArbitre, int gagnante, int resultatEquipe1, int resultatEquipe2, Date dateDuRencontre, String lieuDuRencontre) {
        this.idRencontre = idRencontre;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
        this.idLigue = idLigue;
        this.idArbitre = idArbitre;
        this.gagnante = gagnante;
        this.resultatEquipe1 = resultatEquipe1;
        this.resultatEquipe2 = resultatEquipe2;
        this.dateDuRencontre = dateDuRencontre;
        this.lieuDuRencontre = lieuDuRencontre;
    }

    public void setLieuDuRencontre(String lieuDuRencontre) {
        this.lieuDuRencontre = lieuDuRencontre;
    }




    public RencontreModel() {
    }
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

    public int getGagnante() {
        return gagnante;
    }

    public void setGagnante(int gagnante) {
        this.gagnante = gagnante;
    }
}
