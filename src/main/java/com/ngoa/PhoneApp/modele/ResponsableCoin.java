package com.ngoa.PhoneApp.modele;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "responsableCoin")
public class ResponsableCoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "code_user")
    private String codeUser;
    private String poste;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "user")
    private User user;
}
