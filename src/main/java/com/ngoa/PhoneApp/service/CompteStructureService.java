package com.ngoa.PhoneApp.service;

import com.ngoa.PhoneApp.dto.UserResponsableCompteStructDTO;
import com.ngoa.PhoneApp.modele.CompteStructure;
import com.ngoa.PhoneApp.modele.Produit;
import com.ngoa.PhoneApp.repository.CompteStructureRepository;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<UserResponsableCompteStructDTO> getAllUserResponsableCompteStructDTO(){
        return compteStructureRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList())
                ;
    }

    private UserResponsableCompteStructDTO convertEntityToDto(CompteStructure compteStructure){
        UserResponsableCompteStructDTO userResponsableCompteStructDTO = new UserResponsableCompteStructDTO();
        userResponsableCompteStructDTO.setCompteStructId(compteStructure.getId());
        userResponsableCompteStructDTO.setNumeroCniUser(compteStructure.getResponsableCoin().getUser().getNumeroCNI());
        userResponsableCompteStructDTO.setPoste(compteStructure.getResponsableCoin().getPoste());

        return  userResponsableCompteStructDTO;
    }
}
