package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.Auth;
import com.duocdevs.asistrack.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public Auth registrar(Auth auth) {
        return authRepository.save(auth);
    }

    public Optional<Auth> autenticar(String email, String contrasena) {
        return authRepository.findByEmail(email)
                .filter(auth -> auth.getContrasena().equals(contrasena));
    }
}


