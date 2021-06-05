package com.liguebasketball.basketballsousse.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;


@Entity

@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Ligue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLigue;

    @Column
    private String nomLigue;

   @OneToMany(mappedBy = "ligue")
    private Collection<Journee> journee;

@OneToMany(mappedBy = "ligue")
    private Collection<Rencontre> rencontre;


}
