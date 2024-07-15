package com.aluracursos.forohub.data;

public record DataUsuario(
        Long id,
        String nombre,
        String contraseña,
        String correo_electronico
) {}
