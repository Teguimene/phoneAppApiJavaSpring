package com.ngoa.PhoneApp.service;

import com.ngoa.PhoneApp.modele.Produit;

import lombok.*;
import com.ngoa.PhoneApp.repository.ProduitRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	public Optional<Produit> getProduit(final Long id) {
		return produitRepository.findById(id);
	}
	
	public Iterable<Produit> getProduits() {
		return produitRepository.findAll();
	}
	
	public void deleteProduit(final Long id) {
		produitRepository.deleteById(id);
	}
	
	public Produit saveProduit(Produit produit) {
		Produit saveProduit = produitRepository.save(produit);
		return saveProduit;
	}
}
