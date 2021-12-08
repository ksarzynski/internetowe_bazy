package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Entity;
import pl.edu.pwr.bd2_cinema_app.model.UserEntity;
import pl.edu.pwr.bd2_cinema_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }
    @PostMapping("/users")
    void addUser(@RequestBody UserEntity user) {
        userRepository.save(user);
    }
}
