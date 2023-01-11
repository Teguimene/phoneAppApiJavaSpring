package com.ngoa.PhoneApp.controller;

import com.ngoa.PhoneApp.modele.User;
import com.ngoa.PhoneApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> user = userService.getUser();
        List<User> list = new ArrayList<User>();
        user.forEach(list::add);
        if (list.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(user);
    }
}
