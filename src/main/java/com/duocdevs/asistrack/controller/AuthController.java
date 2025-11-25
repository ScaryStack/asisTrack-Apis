package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Auth;
import com.duocdevs.asistrack.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Auth> registrar(@RequestBody Auth auth) {
        return ResponseEntity.ok(authService.registrar(auth));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password) {

        return authService.autenticar(email, password)
                .map(auth -> ResponseEntity.ok("Login exitoso"))
                .orElse(ResponseEntity.status(401).body("Credenciales incorrectas"));
    }
}


