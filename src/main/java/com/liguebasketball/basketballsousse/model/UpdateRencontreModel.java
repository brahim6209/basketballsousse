package com.liguebasketball.basketballsousse.model;

import com.liguebasketball.basketballsousse.entities.Arbitre;
import com.liguebasketball.basketballsousse.entities.Equipe;
import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Ligue;
import lombok.Data;

@Data
public class UpdateRencontreModel {
    private  Long idRencontre;
    private Long idEquipe1;


    private Long idEquipe2;


    private Long idJournee;
    private Long idLigue;
    private Long idArbitre;
    private Integer gagnante;

    public UpdateRencontreModel() {
    }

    public UpdateRencontreModel(Long idRencontre, Long idEquipe1, Long idEquipe2, Long idJournee, Long idLigue, Long idArbitre, int gagnante) {
        this.idRencontre = idRencontre;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
        this.idLigue = idLigue;
        this.idArbitre = idArbitre;
        this.gagnante = gagnante;
    }
}
