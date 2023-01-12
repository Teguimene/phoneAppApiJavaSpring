package com.ngoa.PhoneApp;

import com.ngoa.PhoneApp.modele.CompteStructure;
import com.ngoa.PhoneApp.modele.ResponsableCoin;
import com.ngoa.PhoneApp.modele.User;
import com.ngoa.PhoneApp.repository.CompteStructureRepository;
import com.ngoa.PhoneApp.repository.ResponsableCoinRepository;
import com.ngoa.PhoneApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhoneAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PhoneAppApplication.class, args);
	}

}
