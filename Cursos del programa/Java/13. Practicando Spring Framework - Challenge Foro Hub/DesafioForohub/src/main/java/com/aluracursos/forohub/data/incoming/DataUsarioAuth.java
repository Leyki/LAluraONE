package com.aluracursos.forohub.data.incoming;

import jakarta.validation.constraints.NotBlank;

public record DataUsarioAuth(
        @NotBlank String nombre,
        @NotBlank String contraseña
) {}
