package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.Vozac;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private Vozac vozac;
    private ArrayList<Kazna> kazne;
}
