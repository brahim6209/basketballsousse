package com.liguebasketball.basketballsousse.Controller;


import com.liguebasketball.basketballsousse.dao.EquipeRepository;
import com.liguebasketball.basketballsousse.dao.JourneeRepository;
import com.liguebasketball.basketballsousse.dao.RencontreRepository;
import com.liguebasketball.basketballsousse.entities.Equipe;
import com.liguebasketball.basketballsousse.entities.Rencontre;
import com.liguebasketball.basketballsousse.model.RencontreResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    private JourneeRepository journeeRepository;

    @Autowired
    private RencontreRepository rencontreRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/allRencontre")
    public List<RencontreResult> getRencontre(){

        List<RencontreResult> allRencontre= new ArrayList<RencontreResult>();
        for (Rencontre rencontre : rencontreRepository.findAll()) {
            RencontreResult rencontreResult = new RencontreResult();
            rencontreResult.setDateDuMatch(rencontre.getDateDuMatch());
            System.out.println(equipeRepository.getById(rencontre.getIdEquipe1()));
            Equipe eq1=equipeRepository.getById(rencontre.getIdEquipe1());
           rencontreResult.setIdEquipe1(eq1);



            allRencontre.add(rencontreResult);
        }
        return allRencontre;
    }


}
