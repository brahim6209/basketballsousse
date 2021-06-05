package com.liguebasketball.basketballsousse.dao;


import com.liguebasketball.basketballsousse.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRole(String roleName);
}
