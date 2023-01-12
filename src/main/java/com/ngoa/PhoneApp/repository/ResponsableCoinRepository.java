package com.ngoa.PhoneApp.repository;

import com.ngoa.PhoneApp.modele.ResponsableCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableCoinRepository extends JpaRepository<ResponsableCoin, Long> {
}
