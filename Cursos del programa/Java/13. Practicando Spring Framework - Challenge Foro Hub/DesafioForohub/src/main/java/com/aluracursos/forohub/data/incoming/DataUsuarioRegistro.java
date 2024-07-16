package com.aluracursos.forohub.data.incoming;

import jakarta.validation.constraints.NotBlank;

public record DataUsuarioRegistro(
        @NotBlank String nombre,
        @NotBlank String contraseña,
        @NotBlank String correo_electronico
) {}
