package com.liguebasketball.basketballsousse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassementModel {

    private Long idEquipe;
    private String nomEquipe;
    private int nbMatchJoueur;
    private  int pointMarquer;
    private int pointEncaisser;
    private int nbVictoire;
    private  int nbDefaite;
    private  int  nbPointsTotale;
}
