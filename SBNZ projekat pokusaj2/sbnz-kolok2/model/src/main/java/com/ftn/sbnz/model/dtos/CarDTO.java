package com.ftn.sbnz.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String registrationNumber;
    private String carModel;
    private String carBrand;
    private String carColor;
}
