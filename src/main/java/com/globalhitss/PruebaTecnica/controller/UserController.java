package com.globalhitss.PruebaTecnica.controller;

import com.globalhitss.PruebaTecnica.interfaces.UserRepository;
import com.globalhitss.PruebaTecnica.model.GenericResponse;
import com.globalhitss.PruebaTecnica.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User postUser(@RequestBody User bodyUser){
        return userRepository.save(bodyUser);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAllByStatusTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id)
    {
        User user = userRepository.findByStatusTrueAndId(id);
        if(user == null){
            String errorMessage = "No existe el usuario con id " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("")
    public User putUserById(@RequestBody User bodyUser){
        return userRepository.save(bodyUser);
    }

    @PutMapping("/{id}/activate")
    public User putUserActivate(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe el usuario con id " + id));

        user.setStatus(true);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el usuario con id " + id));
        user.setStatus(false);
        userRepository.save(user);

        String message = "Se eliminó correctamente el usuario con id " + id;
        return ResponseEntity.ok(message);
    }
}
