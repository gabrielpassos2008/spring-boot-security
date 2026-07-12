package com.example.security.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long idUsuario, String email) {
}
