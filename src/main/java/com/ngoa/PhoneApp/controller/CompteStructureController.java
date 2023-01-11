package com.ngoa.PhoneApp.controller;

import com.ngoa.PhoneApp.modele.CompteStructure;
import com.ngoa.PhoneApp.modele.Produit;
import com.ngoa.PhoneApp.service.CompteStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompteStructureController {
    @Autowired
    private CompteStructureService compteStructureServiceService;

    @GetMapping("/compteStructures")
    public ResponseEntity<Iterable<CompteStructure>> getCompteStructures() {
        Iterable<CompteStructure> compteStructures = compteStructureServiceService.getCompteStruct();
        List<CompteStructure> list = new ArrayList<CompteStructure>();
        compteStructures.forEach(list::add);
        if (list.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(compteStructures);
    }

    @PostMapping("/compteStructures")
    public ResponseEntity<CompteStructure> create(@RequestBody CompteStructure compteStructure) {
        CompteStructure compteStructures = compteStructureServiceService.saveCompteStructure(compteStructure);

        return ResponseEntity.ok().body(compteStructures);
    }
}
