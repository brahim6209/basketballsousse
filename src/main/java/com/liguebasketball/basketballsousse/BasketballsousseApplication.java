package com.liguebasketball.basketballsousse;

import com.liguebasketball.basketballsousse.entities.*;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.management.relation.Role;

@SpringBootApplication
public class BasketballsousseApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BasketballsousseApplication.class, args);}

        @Autowired
        RepositoryRestConfiguration repositoryRestConfiguration;



        @Override
        public void run(String... args) throws Exception {
            repositoryRestConfiguration.exposeIdsFor(Player.class);
            repositoryRestConfiguration.exposeIdsFor(Equipe.class);
            repositoryRestConfiguration.exposeIdsFor(Arbitre.class);
            repositoryRestConfiguration.exposeIdsFor(Journee.class);

            repositoryRestConfiguration.exposeIdsFor(AppUser.class);
            repositoryRestConfiguration.exposeIdsFor(Role.class);
            repositoryRestConfiguration.exposeIdsFor(Rencontre.class);
            repositoryRestConfiguration.exposeIdsFor(Ligue.class);



        }


}
