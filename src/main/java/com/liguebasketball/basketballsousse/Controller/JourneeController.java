package com.liguebasketball.basketballsousse.Controller;

import com.liguebasketball.basketballsousse.dao.JourneeRepository;
import com.liguebasketball.basketballsousse.dao.LigueRepository;
import com.liguebasketball.basketballsousse.dao.RencontreRepository;
import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Ligue;
import com.liguebasketball.basketballsousse.entities.Rencontre;
import com.liguebasketball.basketballsousse.model.JourneeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class JourneeController {

  @Autowired
    JourneeRepository journeeRepository;
@Autowired
    LigueRepository ligueRepository;
@Autowired
    RencontreRepository rencontreRepository;

    @PostMapping("/addJournee")
    private void addJournee(@RequestBody JourneeModel journeeModel) {
        Journee newJournee=new Journee();
        if(journeeModel.getLigue() != null) {
            Ligue ligue= ligueRepository.getById(journeeModel.getLigue());
            newJournee.setLigue(ligue);
        }
        newJournee.setDesignation(journeeModel.getDesignation());


       journeeRepository.save(newJournee);
    }
    @GetMapping("/allJournee")
    private HashMap<String, Object> getAllJournee(){
        HashMap<String, Object> allJournee=new HashMap<String, Object>();
        allJournee.put("journee", journeeRepository.findAll());
        allJournee.put("ligue", ligueRepository.findAll());
        return allJournee;
    }
    @PutMapping("/updateJournee")
    private void updateJournee(@RequestBody JourneeModel journeeModel) {
        Journee newJournee=journeeRepository.findById(Long.valueOf(journeeModel.getIdJournee())).get();
        if(journeeModel.getLigue() != null) {
            Ligue ligue= ligueRepository.getById(journeeModel.getLigue());
            newJournee.setLigue(ligue);
        }
        newJournee.setDesignation(journeeModel.getDesignation());

        journeeRepository.save(newJournee);
    }
    @GetMapping("/getJourneeById/{id}")
    public  Journee getJourneeById(@PathVariable("id") Long id){
        if(id!=null){
            Journee journee =journeeRepository.findById(id).get();
            return  journee;
        }
        return null;
    }
  @GetMapping("/getJourneeByLigue/{id}")
    public List<Rencontre> getJourneeByLigue (@PathVariable("id") Long id){
      System.out.println(id);
      if(id!=null) {
          Ligue ligue = ligueRepository.findById(id).get();
          List<Journee> allJournee= journeeRepository.findByLigue(ligue) ;

          allJournee.forEach((journee) -> {
              System.out.println(journee);
//              List<Rencontre> findByJourneeRencontres=null;
//            findByJourneeRencontres =rencontreRepository.findByJournee(journee);
//          System.out.println(findByJourneeRencontres);

          });

          return null;

      }

      return  null;
    }

}
