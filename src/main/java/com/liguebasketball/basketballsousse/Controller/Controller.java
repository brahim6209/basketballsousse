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

import com.liguebasketball.basketballsousse.entities.*;
import com.liguebasketball.basketballsousse.model.ClassementModel;
import com.liguebasketball.basketballsousse.model.RencontreModel;

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
    private  PlayerRepository playerRepository;
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
    public List<RencontreModel> getAllRencontre() {

        List<RencontreModel> allRencontre = new ArrayList<RencontreModel>();
        rencontreRepository.findAll().stream().forEach((rencontre) -> {
            RencontreModel rencontreResult = new RencontreModel();
            rencontreResult.setIdRencontre(rencontre.getIdRencontre());
            rencontreResult.setLieuDuRencontre(rencontre.getLieuDuRencontre());
            rencontreResult.setDateDuRencontre(rencontre.getDateDuRencontre());
            rencontreResult.setResultatEquipe1(rencontre.getResultatEquipe1());
            rencontreResult.setResultatEquipe2(rencontre.getResultatEquipe2());
            if (rencontre.getIdEquipe1()!=null){
            Equipe eq1 = equipeRepository.getById(rencontre.getIdEquipe1());
            rencontreResult.setIdEquipe1(eq1);}

            if (rencontre.getIdEquipe2()!=null){
                Equipe eq2 = equipeRepository.getById(rencontre.getIdEquipe2());
                rencontreResult.setIdEquipe2(eq2);}

            if (rencontre.getIdJournee()!=null){
            Journee journee =journeeRepository.getById(rencontre.getIdJournee());
            rencontreResult.setIdJournee(journee);}
            if (rencontre.getIdLigue()!=null){
            Ligue ligue =ligueRepository.getById(rencontre.getIdLigue());
            rencontreResult.setIdLigue(ligue);}

if (rencontre.getIdArbitre()!=null){
    Arbitre arb =arbitreRepository.getById(rencontre.getIdArbitre());
    rencontreResult.setIdArbitre(arb);
}

            allRencontre.add(rencontreResult);
        });
        return allRencontre;
    }

    @PutMapping("/update")
    public void update(@RequestBody Rencontre rencontre) {
        System.out.println(rencontre);
        Rencontre updateRencontre = rencontreRepository.findById(rencontre.getIdRencontre()).get();
        updateRencontre.setDateDuRencontre(rencontre.getDateDuRencontre());
        updateRencontre.setIdEquipe1(rencontre.getIdEquipe1());
        updateRencontre.setIdEquipe2(rencontre.getIdEquipe2());

        //debut

        if(rencontre.getIdEquipe1()!=null){
        Equipe equipe1 =equipeRepository.findById(rencontre.getIdEquipe1()).get();
        if(equipe1.getNbMatchJoueur()==null){
            equipe1.setNbMatchJoueur(1);
        }else{ equipe1.setNbMatchJoueur(equipe1.getNbMatchJoueur()+1);}
            if(equipe1.getNbMatchJouerDomicile()==null){
                equipe1.setNbMatchJouerDomicile(1);
            }else { equipe1.setNbMatchJouerDomicile(equipe1.getNbMatchJouerDomicile()+1);}
            if(equipe1.getNbPointMarquer()==null){equipe1.setNbPointMarquer(1);}else {
        equipe1.setNbPointMarquer(equipe1.getNbPointMarquer()+rencontre.getResultatEquipe1());}
            if(equipe1.getNbPointEncaisses()==null){equipe1.setNbPointEncaisses(1);}else {
        equipe1.setNbPointEncaisses(equipe1.getNbPointEncaisses()+rencontre.getResultatEquipe2());}

         if (rencontre.getGagnante()==1){
             if(equipe1.getNbVictoire()==null){equipe1.setNbVictoire(1);}else {
            equipe1.setNbVictoire(equipe1.getNbVictoire()+1);}
            equipe1.setNbPointsTotale(equipe1.getNbPointsTotale()+3);

        }
            if (rencontre.getGagnante()==2){
                if(equipe1.getNbDefaite()==null){equipe1.setNbDefaite(1);}else {
                equipe1.setNbDefaite(equipe1.getNbDefaite()+1);}
            }

            if (rencontre.getGagnante()==3){
                if(equipe1.getNbPointsTotale()==null){equipe1.setNbPointsTotale(1);}else {
                equipe1.setNbPointsTotale(equipe1.getNbPointsTotale()+1);}
            }


        }
        //Fin

        //debut

        if(rencontre.getIdEquipe2()!=null){
            Equipe equipe2 =equipeRepository.findById(rencontre.getIdEquipe2()).get();
            if(equipe2.getNbMatchJoueur()==null){equipe2.setNbMatchJoueur(1);}else {
            equipe2.setNbMatchJoueur(equipe2.getNbMatchJoueur()+1);}
            if(equipe2.getNbMatchJouerExterieur()==null){equipe2.setNbMatchJouerExterieur(1);}else {
            equipe2.setNbMatchJouerExterieur(equipe2.getNbMatchJouerExterieur()+1);}

            if(equipe2.getNbPointMarquer()==null){equipe2.setNbPointMarquer(1);}else {
            equipe2.setNbPointMarquer(equipe2.getNbPointMarquer()+rencontre.getResultatEquipe2());}


            if(equipe2.getNbPointEncaisses()==null){equipe2.setNbPointEncaisses(1);}else {
            equipe2.setNbPointEncaisses(equipe2.getNbPointEncaisses()+rencontre.getResultatEquipe1());}
            if (rencontre.getGagnante()==1){
                if(equipe2.getNbDefaite()==null){equipe2.setNbDefaite(1);}else {
                equipe2.setNbDefaite(equipe2.getNbDefaite()+1);}


            }
            if (rencontre.getGagnante()==2){
                if(equipe2.getNbPointsTotale()==null){equipe2.setNbPointsTotale(1);}else {
                equipe2.setNbPointsTotale(equipe2.getNbPointsTotale()+3);}
                if(equipe2.getNbVictoire()==null){equipe2.setNbVictoire(1);}else {
                equipe2.setNbVictoire(equipe2.getNbVictoire()+1);}

            }

            if (rencontre.getGagnante()==3){

                equipe2.setNbPointsTotale(equipe2.getNbPointsTotale()+1);
            }


        }
        //Fin

        updateRencontre.setLieuDuRencontre(rencontre.getLieuDuRencontre());
        updateRencontre.setResultatEquipe1(rencontre.getResultatEquipe1());
        updateRencontre.setResultatEquipe2(rencontre.getResultatEquipe2());
        rencontre.setResultatEquipe1(rencontre.getResultatEquipe1());
        rencontre.setResultatEquipe2(rencontre.getResultatEquipe2());
        if (rencontre.getIdArbitre()!=null){
            Arbitre arbitre = arbitreRepository.findById(rencontre.getIdArbitre()).get();
            updateRencontre.setArbitre(arbitre);
            updateRencontre.setIdArbitre(rencontre.getIdArbitre());
        }
        if (rencontre.getIdLigue()!=null){
            Ligue ligue = ligueRepository.findById(rencontre.getIdLigue()).get();
            updateRencontre.setLigue(ligue);
            updateRencontre.setIdLigue(rencontre.getIdLigue());
        }


        updateRencontre.setGagnante(rencontre.getGagnante());

        rencontreRepository.save(updateRencontre);


    }

    @PostMapping("/save")
    public void save(@RequestBody Rencontre rencontre) {
        System.out.println(rencontre);
        Rencontre updateRencontre = new Rencontre();
        updateRencontre.setDateDuRencontre(rencontre.getDateDuRencontre());
        updateRencontre.setIdEquipe1(rencontre.getIdEquipe1());
        updateRencontre.setIdEquipe2(rencontre.getIdEquipe2());
        updateRencontre.setLieuDuRencontre(rencontre.getLieuDuRencontre());
        updateRencontre.setResultatEquipe1(rencontre.getResultatEquipe1());
        updateRencontre.setResultatEquipe2(rencontre.getResultatEquipe2());
        rencontre.setResultatEquipe1(rencontre.getResultatEquipe1());
        rencontre.setResultatEquipe2(rencontre.getResultatEquipe2());

        updateRencontre.setGagnante(rencontre.getGagnante());
        if (rencontre.getIdArbitre()!=null){
            Arbitre arbitre = arbitreRepository.findById(rencontre.getIdArbitre()).get();
            updateRencontre.setArbitre(arbitre);
            updateRencontre.setIdArbitre(rencontre.getIdArbitre());
        }
        if (rencontre.getIdJournee()!=null){
            Journee journee = journeeRepository.findById(rencontre.getIdJournee()).get();
            updateRencontre.setJournee(journee);
            updateRencontre.setIdJournee(rencontre.getIdJournee());
        }

        if (rencontre.getIdLigue()!=null){
            Ligue ligue = ligueRepository.findById(rencontre.getIdLigue()).get();
            updateRencontre.setLigue(ligue);
            updateRencontre.setIdLigue(rencontre.getIdLigue());
        }

//        if (rencontre.getIdLigue()!=null){
//            Ligue ligue = ligueRepository.findById(rencontre.getIdLigue()).get();
//            updateRencontre.setLigue(ligue);
//        }
//        if (rencontre.getIdLigue()!=null){
//            Ligue ligue = ligueRepository.findById(rencontre.getIdLigue()).get();
//            updateRencontre.setLigue(ligue);
//        }
        rencontreRepository.save(updateRencontre);



    }

    @GetMapping("/allClassement/{id}")
    public List<Rencontre> getAllClassement(@PathVariable("id") Long id) {
        System.out.println(id);
        List<Rencontre> rencontreByLigue = null;

        if(id!=null){
            rencontreByLigue=  rencontreRepository.findByIdLigue(id);
            rencontreByLigue.stream().forEach((rencontre)->{
                ClassementModel classementModel =new ClassementModel();
            });
            return rencontreByLigue;

        }

        return null;

    }
    @GetMapping("/allPlayers")
    public List<Player> getAllPlayer(){
        List<Player> allPlayers =playerRepository.findAll();
        return allPlayers;
    }
}
