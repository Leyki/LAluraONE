package com.aluracursos.forohub.data.outgoing;

import com.aluracursos.forohub.models.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public record DataUsuarioPublic(
        Long id,
        String nombre,
        String correo_electronico
) {
    public DataUsuarioPublic(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo_electronico());
    }
}