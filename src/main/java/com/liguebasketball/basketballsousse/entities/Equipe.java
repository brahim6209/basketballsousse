package com.liguebasketball.basketballsousse.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
//@JsonInclude(value= JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEquipe;


    @Column(unique = true,length = 50 ,nullable = false)
    private String nom;

    @Column
    private Integer nbMatchJoueur;

@Column
private Integer nbVictoire;
@Column
private  Integer nbDefaite;

@Column
private  Integer  nbPointsTotale;
    @Column
    private Integer nbMatchJouerDomicile;

    @Column
    private Integer nbMatchJouerExterieur;

    @Column
    private Integer nbPointMarquer;

    @Column
    private Integer nbPointEncaisses;

    @Column
    private String logo;



    @OneToMany(mappedBy = "equipe")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Player> player;





    public Collection<Player> getPlayer() {
        return player;
    }






    @JsonIgnore
    public void setPlayer(Collection<Player> player) {
        this.player = player;
    }
}
