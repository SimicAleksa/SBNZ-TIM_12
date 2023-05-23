package com.ftn.sbnz.model;

import lombok.*;
import org.kie.api.definition.type.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kazna  {

    @Id
    private String id;
    private String registarskiBrojVozila;
    private double novcanaKazna;
    private int brojKaznenihBodova;
    private int duzinaZatvorskeKazne;
//    private LocalDateTime datum;

}
