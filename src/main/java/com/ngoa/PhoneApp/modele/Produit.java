package com.ngoa.PhoneApp.modele;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
public class Produit {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50)
	private String nom;
	
	
	@Column(length = 150)
	private String description;
	
	private Integer prix;
}
