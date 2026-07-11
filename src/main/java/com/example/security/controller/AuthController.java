package com.example.security.controller;


import com.example.security.dto.request.LoginResquest;
import com.example.security.dto.request.ResgisterUsuarioRequest;
import com.example.security.dto.response.LoginResponse;
import com.example.security.dto.response.ResgisterUsuarioResponse;
import com.example.security.model.Usuario;
import com.example.security.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@Valid @RequestBody LoginResquest resquest){
        return null;
    }

    @PostMapping("/registar")
    public ResponseEntity<ResgisterUsuarioResponse> resgistar (@Valid @RequestBody ResgisterUsuarioRequest request){
        Usuario novoUsuario = new Usuario();

        novoUsuario.setSenha(passwordEncoder.encode(request.senha()));
        novoUsuario.setEmail(request.email());
        novoUsuario.setNome(request.nome());

        repository.save(novoUsuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResgisterUsuarioResponse(novoUsuario.getNome(), novoUsuario.getEmail()));
    }
}






