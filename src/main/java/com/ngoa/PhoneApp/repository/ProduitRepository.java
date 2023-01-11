package com.ngoa.PhoneApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ngoa.PhoneApp.modele.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
