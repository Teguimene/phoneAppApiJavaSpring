package com.ngoa.PhoneApp.dto;

import lombok.Data;

@Data
public class UserResponsableCompteStructDTO {
    /* compte_structure */
    private Long compteStructId;

    /* user */
    private int NumeroCniUser;

    private  String responsable;

    /* reponsable */
    private String poste;
}
