package com.liguebasketball.basketballsousse.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppUser {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String username;	
	private String password;
	private boolean active;
	private String role;

}
