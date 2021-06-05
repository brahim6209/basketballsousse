package com.liguebasketball.basketballsousse.model;

import lombok.Data;

import java.util.Date;


@Data
public class RencontreModel {
    private Date dateDuMatch;

    private String lieuDuMatch;


    private  Long idEquipe1;


    private Long idEquipe2;


    private Long idJournee;
     private Long idLigue;

}
