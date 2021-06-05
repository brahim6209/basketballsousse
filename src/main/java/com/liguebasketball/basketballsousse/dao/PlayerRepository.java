package com.liguebasketball.basketballsousse.dao;

import com.liguebasketball.basketballsousse.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
