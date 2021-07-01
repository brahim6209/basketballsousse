package com.liguebasketball.basketballsousse.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppUser implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.	AUTO)
	private Long idUser;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	private String role;

	private boolean active;


}
