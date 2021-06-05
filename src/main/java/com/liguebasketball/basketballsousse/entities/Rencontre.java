package com.liguebasketball.basketballsousse.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRencontre;

    @Column
    private Date dateDuMatch;

    @Column
    private String lieuDuMatch;

    @Column
    private  Long idEquipe1;

    @Column
    private Long idEquipe2;

    @ManyToOne
    private     Journee journee;

    @ManyToOne
    private  Ligue ligue;




}

