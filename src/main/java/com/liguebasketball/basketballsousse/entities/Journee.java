package com.liguebasketball.basketballsousse.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Journee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJournee;

  /*  @Column
    private Date dateDuMatch;*/

    @Column
    private String designation;

 /*   @Column
    private int resultatEquipe1;

    @Column
    private int resultatEquipe2;

    @Column
    private boolean aDomicile;



    @Column
    private boolean ganante;
*/

  /*  @Column
    private int fauteProvoquer;

    @Column
    private int passeDecisives;

    @Column
    private int ballesPerdues;

    @Column
    private int interception;*/

   @OneToMany (mappedBy = "journee")
    private Collection<Arbitre> arbitres;

    @ManyToOne
	private Ligue ligue;

    @OneToMany(mappedBy = "journee")

    private Collection<Rencontre> rencontres;


}
