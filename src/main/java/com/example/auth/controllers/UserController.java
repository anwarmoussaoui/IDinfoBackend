package com.example.auth.controllers;


import com.example.auth.entities.CodeVerif;
import com.example.auth.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public")
public class UserController {
    @Autowired
    private final AuthenticationService authservice;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authservice.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws InterruptedException {
        return ResponseEntity.ok(authservice.login(request));
    }
    @PostMapping("/changePassword")
    public String changePassword(@RequestBody AuthenticationRequest request){
      return authservice.changePassword(request);
    }
    @PostMapping ("/verification")
    public  ResponseEntity<AuthenticationResponse> verify(@RequestBody CodeVerif codeVerif){

        return ResponseEntity.ok(authservice.verify(codeVerif.getEmail(),codeVerif.getCode()));
    }




}
