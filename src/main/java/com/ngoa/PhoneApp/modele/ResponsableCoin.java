package com.ngoa.PhoneApp.modele;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "responsable_coin")
@Data
@NoArgsConstructor
public class ResponsableCoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeUser;
    private String poste;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
