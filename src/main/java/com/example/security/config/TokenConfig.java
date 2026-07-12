package com.example.security.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.security.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenConfig {

    private String secret = "secret";

    public  String gerarToken(Usuario usuario){

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("idUsuario", usuario.getId())
                .withSubject(usuario.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(100000))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }
}
