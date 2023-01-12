package com.ngoa.PhoneApp.modele;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="COMPTE_STRUCTURE")
@Data
@NoArgsConstructor
public class CompteStructure {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(length = 50)
    private String NomStructure;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "responsaable_id")
    private ResponsableCoin responsableCoin;
}
