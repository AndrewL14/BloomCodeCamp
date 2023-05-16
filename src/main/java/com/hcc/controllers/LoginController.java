package com.hcc.controllers;

import com.hcc.entities.DTOs.AuthCredentialRequest;
import com.hcc.entities.User;
import com.hcc.utils.JWtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWtUtils jwtUtils;

    /**
     *  Checks if the users credentials are valid or not. if valid sets' header to authorized
     *  sends the JWT and returns the username else returns an unauthorized status.
     * @param authCredentialRequestDto The user's username/password.
     * @return A new response entity containing either a header, JWT and username or
     * A status unauthorized.
     */
    @PostMapping(value = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> login(@RequestBody AuthCredentialRequest authCredentialRequestDto) {

        try{
            Authentication authentication = authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(authCredentialRequestDto.getUsername(),
                            authCredentialRequestDto.getPassword()));
            User user = (User) authentication.getPrincipal();
            user.setPassword(null);
            String token = jwtUtils.generateToken(user);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body(user.getUsername());
        } catch (BadCredentialsException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
