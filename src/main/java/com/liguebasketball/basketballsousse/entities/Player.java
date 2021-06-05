package com.liguebasketball.basketballsousse.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJoueur;

    @Column/*(unique = true,nullable = false , length = 55)*/
    private String matricule;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private Date dateNaissance;




    @Column
    private String nationnalite;

    @Column
    private String photo;

    @Column
    private boolean Licence;

    @Column
    private String numeroLicence;

   @ManyToOne
   private Equipe equipe;
   
}
