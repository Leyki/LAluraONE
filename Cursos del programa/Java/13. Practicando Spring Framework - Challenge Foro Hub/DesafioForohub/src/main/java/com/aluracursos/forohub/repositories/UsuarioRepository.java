package com.aluracursos.forohub.repositories;


import com.aluracursos.forohub.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String username);
}
