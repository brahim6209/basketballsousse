package com.liguebasketball.basketballsousse.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
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


    @Column
    private String designation;




//   @OneToMany (mappedBy = "journee")
//   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Collection<Arbitre> arbitres;

    @ManyToOne
	private Ligue ligue;

    @OneToMany(mappedBy = "journee")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Rencontre> rencontres;


}
