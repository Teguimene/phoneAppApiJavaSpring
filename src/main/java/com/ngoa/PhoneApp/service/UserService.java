package com.ngoa.PhoneApp.service;
import com.ngoa.PhoneApp.modele.CompteStructure;
import com.ngoa.PhoneApp.modele.User;
import com.ngoa.PhoneApp.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUser() {
        return userRepository.findAll();
    }
}
