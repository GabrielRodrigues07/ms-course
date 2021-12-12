package com.devsuperior.hruser.resources;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UseRepository repository;


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {

        User obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}