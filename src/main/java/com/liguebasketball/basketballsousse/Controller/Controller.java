package com.liguebasketball.basketballsousse.Controller;







import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liguebasketball.basketballsousse.dao.*;

import com.liguebasketball.basketballsousse.entities.Arbitre;
import com.liguebasketball.basketballsousse.entities.Equipe;
import com.liguebasketball.basketballsousse.entities.Ligue;
import com.liguebasketball.basketballsousse.entities.Rencontre;
import com.liguebasketball.basketballsousse.model.RencontreModel;
import com.liguebasketball.basketballsousse.model.RencontreResult;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private LigueRepository ligueRepository;

@Autowired
    ArbitreRepository arbitreRepository;
 /*@GetMapping("/allRencontre")
    public List<HashMap<String, Object> getRencontre(){

        List<HashMap<String, Object>> allRencontre= new ArrayList<>();
        for (Rencontre rencontre : rencontreRepository.findAll()) {
            HashMap<String, Object> eq1 = new HashMap<String, Object>();

            HashMap<String, Object> eq2 = new HashMap<String, Object>();

            HashMap<String, Object> ligue= new HashMap<String, Object>();
            HashMap<String, Object> arbitre= new HashMap<String, Object>();
            eq1.put("eq1",equipeRepository.findById(rencontre.getIdEquipe1()));
            eq2.put("eq2",equipeRepository.findById(rencontre.getIdEquipe2()));




            allRencontre.add(eq1);
            allRencontre.add(eq2);

        }
        return allRencontre;
    }*/
@GetMapping("/all")
 public List<RencontreModel> getAllRencontre(){

     List<RencontreModel> allRencontre= new ArrayList<RencontreModel>();
     rencontreRepository.findAll().stream().forEach((rencontre)->{
         RencontreModel rencontreResult = new RencontreModel();
         rencontreResult.setIdRencontre(rencontre.getIdRencontre());
rencontreResult.setLieuDuRencontre(rencontre.getLieuDuRencontre());
rencontreResult.setDateDuRencontre(rencontre.getDateDuRencontre());
rencontreResult.setResultatEquipe1(rencontre.getResultatEquipe1());
rencontreResult.setResultatEquipe2(rencontre.getResultatEquipe2());
         Equipe eq1=equipeRepository.getById(rencontre.getIdEquipe1());
         rencontreResult.setIdEquipe1(eq1);
         Equipe eq2=equipeRepository.getById(rencontre.getIdEquipe2());
         rencontreResult.setIdEquipe2(eq2);


         allRencontre.add(rencontreResult);
     });
     return allRencontre;
 }

@PutMapping("/update")
    public void update(@RequestBody Rencontre rencontre){
    System.out.println(rencontre);
    Rencontre updateRencontre= rencontreRepository.findById(rencontre.getIdRencontre()).get();
    updateRencontre.setDateDuRencontre(rencontre.getDateDuRencontre());
    updateRencontre.setIdEquipe1(rencontre.getIdEquipe1());
    updateRencontre.setIdEquipe2(rencontre.getIdEquipe2());
    updateRencontre.setLieuDuRencontre(rencontre.getLieuDuRencontre());
    updateRencontre.setResultatEquipe1(rencontre.getResultatEquipe1());
    updateRencontre.setResultatEquipe2(rencontre.getResultatEquipe2());
    rencontre.setResultatEquipe1(rencontre.getResultatEquipe1());
    rencontre.setResultatEquipe2(rencontre.getResultatEquipe2());
    updateRencontre.setIdLigue(rencontre.getIdLigue());

    rencontreRepository.save(updateRencontre);


}

}
