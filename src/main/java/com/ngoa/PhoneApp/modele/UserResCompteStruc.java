package com.ngoa.PhoneApp.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class UserResCompteStruc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Username;
    private int NumeroCNI;
    private String CodePin;

    private String codeUser;
    private String poste;

    private String NomStructure;
}
