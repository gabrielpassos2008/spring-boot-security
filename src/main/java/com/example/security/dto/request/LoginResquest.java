package com.example.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginResquest(@NotEmpty(message = "email e obrigatorio") String senha
                            ,@NotEmpty(message = "senha e obrigatoria") String email) {

}
