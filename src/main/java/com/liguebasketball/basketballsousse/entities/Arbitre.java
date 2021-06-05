package com.liguebasketball.basketballsousse.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArbitre;

    @Column(length = 50)
    private String nom;

    @Column
    private String prenom;

    
    
    @ManyToOne
    private Journee journee;

}
