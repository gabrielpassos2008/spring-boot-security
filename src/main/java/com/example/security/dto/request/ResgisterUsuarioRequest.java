package com.example.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record ResgisterUsuarioRequest(@NotEmpty(message = "nome e obrigatorio") String nome
                                        ,@NotEmpty(message = "email e obrigatorio") String email
                                        ,@NotEmpty(message = "senha e obrigatorio") String senha) {
}
