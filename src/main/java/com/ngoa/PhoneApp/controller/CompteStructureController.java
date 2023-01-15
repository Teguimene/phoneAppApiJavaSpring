package com.ngoa.PhoneApp.controller;

import com.ngoa.PhoneApp.dto.UserResponsableCompteStructDTO;
import com.ngoa.PhoneApp.modele.*;
import com.ngoa.PhoneApp.repository.ResponsableCoinRepository;
import com.ngoa.PhoneApp.repository.UserRepository;
import com.ngoa.PhoneApp.service.CompteStructureService;
import com.ngoa.PhoneApp.service.ResponsableCoinService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponsableCoinRepository responsableCoinRepository;
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
    public ResponseEntity<CompteStructure> create(@RequestBody UserResCompteStruc userResCompteStruc) {

        System.out.println(userResCompteStruc.getUsername());
        User user = new User();
        user.setNumeroCNI(userResCompteStruc.getNumeroCNI());
        user.setUsername(userResCompteStruc.getUsername());
        user.setCodePin(userResCompteStruc.getCodePin());
        userRepository.save(user);

        ResponsableCoin responsableCoin = new ResponsableCoin();
        responsableCoin.setUser(user);
        responsableCoin.setPoste(userResCompteStruc.getPoste());
        responsableCoin.setCodeUser(userResCompteStruc.getCodeUser());
        responsableCoinRepository.save(responsableCoin);

        CompteStructure compteStructure = new CompteStructure();
        compteStructure.setNomStructure(userResCompteStruc.getNomStructure());
        compteStructure.setResponsableCoin(responsableCoin);
        CompteStructure compteStructures = compteStructureService.saveCompteStructure(compteStructure);

        return ResponseEntity.ok().body(compteStructures);
    }


}
