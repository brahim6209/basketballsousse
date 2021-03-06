package com.liguebasketball.basketballsousse.dao;

import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface RencontreRepository extends JpaRepository<Rencontre,Long> {
    public List<Rencontre> findByIdLigue(Long id);
    public List<Rencontre> findByJournee(Journee journee);

}
