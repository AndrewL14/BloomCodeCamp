package com.hcc.controllers;

import com.hcc.entities.Authority;
import com.hcc.entities.DTOs.UpdateAuthCredentialRequest;
import com.hcc.entities.User;
import com.hcc.exceptions.UserNotFoundException;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthorityController {

    @Autowired
    private UserRepository repo;


    @PutMapping(value = "/update")
    ResponseEntity<?> updateAuthority(@RequestBody UpdateAuthCredentialRequest request) {
       User user = repo.findByUsername(request.getUsername())
               .orElseThrow(UserNotFoundException::new);
    }
}
