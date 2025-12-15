package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Auth;
import com.duocdevs.asistrack.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@Tag(name = "Auth", description = "Autenticación y registro de usuarios")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Registrar usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario registrado",
                    content = @Content(schema = @Schema(implementation = Auth.class)))
    })
    public ResponseEntity<Auth> registrar(@RequestBody Auth auth) {
        return ResponseEntity.ok(authService.registrar(auth));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login exitoso"),
            @ApiResponse(responseCode = "401", description = "Credenciales incorrectas")
    })
    public ResponseEntity<String> login(@RequestBody Auth authRequest) {
        return authService.autenticar(authRequest.getEmail(), authRequest.getContrasena())
                .map(a -> ResponseEntity.ok("Login exitoso"))
                .orElse(ResponseEntity.status(401).body("Credenciales incorrectas"));
    }
}



