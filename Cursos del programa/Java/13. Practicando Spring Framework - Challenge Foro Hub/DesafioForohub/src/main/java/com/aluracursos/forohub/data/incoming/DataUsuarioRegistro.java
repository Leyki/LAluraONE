package com.aluracursos.forohub.data.incoming;

public record DataUsuarioRegistro(
        String nombre,
        String contraseña,
        String correo_electronico
) {}
