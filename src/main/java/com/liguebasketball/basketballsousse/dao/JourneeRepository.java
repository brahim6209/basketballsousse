package com.liguebasketball.basketballsousse.dao;


import com.liguebasketball.basketballsousse.entities.Journee;
import com.liguebasketball.basketballsousse.entities.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface JourneeRepository extends JpaRepository<Journee, Long>{

public List<Journee> findByLigue(Ligue ligue);

}
