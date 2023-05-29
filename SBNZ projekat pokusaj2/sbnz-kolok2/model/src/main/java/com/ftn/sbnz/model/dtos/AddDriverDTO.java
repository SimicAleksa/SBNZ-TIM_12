package com.ftn.sbnz.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddDriverDTO {
    private String ime;
    private String prezime;
    private String email;
    private String sifra;
    private String brVozacke;
    private ArrayList<CarDTO> cars;

}
