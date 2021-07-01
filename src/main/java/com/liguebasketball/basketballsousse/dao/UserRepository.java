package com.liguebasketball.basketballsousse.dao;


import com.liguebasketball.basketballsousse.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByUsername(String username);

	@Query("select u from AppUser u where u.role = ?1")
	public List<AppUser> findByRole(String role);
}
