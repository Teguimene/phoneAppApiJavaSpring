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
public class PhoneAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhoneAppApplication.class, args);
	}

	@Autowired
	private CompteStructureRepository compteStructureRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ResponsableCoinRepository responsableCoinRepository;
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setNumeroCNI(12354545);
		user.setUsername("Furel");
		user.setCodePin("12ping");
		userRepository.save(user);

		ResponsableCoin responsableCoin = new ResponsableCoin();
		responsableCoin.setUser(user);
		responsableCoin.setPoste("DG");
		responsableCoin.setCodeUser("User123");
		responsableCoinRepository.save(responsableCoin);

		CompteStructure compteStructure = new CompteStructure();
		compteStructure.setNomStructure("Hysacam");
		compteStructure.setResponsableCoin(responsableCoin);
		compteStructureRepository.save(compteStructure);


	}
}
