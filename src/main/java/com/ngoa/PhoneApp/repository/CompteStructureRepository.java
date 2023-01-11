package com.ngoa.PhoneApp.repository;

import com.ngoa.PhoneApp.modele.CompteStructure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteStructureRepository extends CrudRepository<CompteStructure, Long> {

}
