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

    @OneToMany(mappedBy = "arbitre")
private Collection<Rencontre> rencontre;
}
