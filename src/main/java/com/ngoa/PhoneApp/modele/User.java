package com.ngoa.PhoneApp.modele;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Username;
    private int NumeroCNI;
    private String CodePin;
}
