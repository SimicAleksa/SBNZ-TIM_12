package com.ftn.sbnz.model;

import com.ftn.sbnz.model.VremenskoStanje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lokacija {
    @Id
    private String naziv;
    private int ogranicenje;
    private boolean naseljenoMesto;
    private VremenskoStanje vremenskoStanje;


}