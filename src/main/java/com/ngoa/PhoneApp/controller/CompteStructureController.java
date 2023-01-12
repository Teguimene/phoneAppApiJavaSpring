package com.ngoa.PhoneApp.controller;

import com.ngoa.PhoneApp.dto.UserResponsableCompteStructDTO;
import com.ngoa.PhoneApp.modele.CompteStructure;
import com.ngoa.PhoneApp.modele.Produit;
import com.ngoa.PhoneApp.modele.User;
import com.ngoa.PhoneApp.service.CompteStructureService;
import com.ngoa.PhoneApp.service.UserService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompteStructureController {
    @Autowired
    private CompteStructureService compteStructureService;
    private UserService userService;

    @GetMapping("/user-responsable-compteStruct")
    public List<UserResponsableCompteStructDTO> getAllUserResponsableCompteStructDTO() {
        return compteStructureService.getAllUserResponsableCompteStructDTO();
    }
    private Mapper mapper;

    @GetMapping("/compteStructures")
    public ResponseEntity<Iterable<CompteStructure>> getCompteStructures() {
        Iterable<CompteStructure> compteStructures = compteStructureService.getCompteStruct();
        List<CompteStructure> list = new ArrayList<CompteStructure>();
        compteStructures.forEach(list::add);
        if (list.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(compteStructures);
    }

    @PostMapping("/compteStructures")
    @ResponseBody
    public ResponseEntity<CompteStructure> create(@RequestBody CompteStructure compteStructure) {

//        System.out.println(compteStructure.getNomStructure());
        CompteStructure compteStructures = compteStructureService.saveCompteStructure(compteStructure);
        Long id = compteStructures.getId();

        return ResponseEntity.ok().body(compteStructures);
    }


}
