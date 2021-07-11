package com.liguebasketball.basketballsousse.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRencontre;

    @Column

    private Date dateDuRencontre;

    @Column
    private String lieuDuRencontre;

    @Column
    private  Long idEquipe1;

   @Column
    private Long idEquipe2;
   @Column

   private Long idJournee;

    @Column
    private Long idArbitre;
@Column
private Long idLigue;
    @Column
    private Integer resultatEquipe1;
    @Column
    private Integer resultatEquipe2;
    @Column
    private Integer gagnante;



    @ManyToOne
    private    Journee journee;



    @ManyToOne
    private  Ligue ligue;

    @ManyToOne
    private  Arbitre arbitre;




}

