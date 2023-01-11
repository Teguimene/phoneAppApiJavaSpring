package com.ngoa.PhoneApp.service;

import com.ngoa.PhoneApp.modele.CompteStructure;
import com.ngoa.PhoneApp.modele.Produit;
import com.ngoa.PhoneApp.repository.CompteStructureRepository;
import lombok.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CompteStructureService {
    @Autowired
    private CompteStructureRepository compteStructureRepository;

    public Iterable<CompteStructure> getCompteStruct() {
        return compteStructureRepository.findAll();
    }

    public CompteStructure saveCompteStructure(CompteStructure compteStructure) {

        CompteStructure saveCompteStructure = compteStructureRepository.save(compteStructure);
        return saveCompteStructure;
    }
}
