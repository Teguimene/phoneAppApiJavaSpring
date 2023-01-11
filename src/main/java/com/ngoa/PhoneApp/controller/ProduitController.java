package com.ngoa.PhoneApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ngoa.PhoneApp.modele.Produit;

import com.ngoa.PhoneApp.service.ProduitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	
	/**
	 * Read - Get all produits
	 * @return - An Iterable object of Produit full filled
	 */
	
	@GetMapping("/produits")
	public ResponseEntity<Iterable<Produit>> getProduits() {
		Iterable<Produit> produits = produitService.getProduits();
		List<Produit> list = new ArrayList<Produit>();
		produits.forEach(list::add);
		if (list.size() == 0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(produits);
	}

	@PostMapping("/produits")
	public ResponseEntity<Produit> create(@RequestBody Produit produit) {
		Produit produits = produitService.saveProduit(produit);
		return ResponseEntity.ok().body(produits);
	}

	@GetMapping("/produits/{id}")
	public ResponseEntity  show(@PathVariable Long id) {
		Optional<Produit> produit = produitService.getProduit(id);
		if(produit.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit introuvable");
		}
		return ResponseEntity.ok().body(produit);
	}

}
