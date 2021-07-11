package com.liguebasketball.basketballsousse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JourneeModel {
    private Long idJournee;
    private String designation;
    private Long ligue;
}
