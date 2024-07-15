package com.aluracursos.forohub.infra.security;

import com.aluracursos.forohub.models.Usuario;
import com.aluracursos.forohub.data.incoming.DataUsarioAuth;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DataUsarioAuth dataUsuarioAuth) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataUsuarioAuth.nombre(), dataUsuarioAuth.contraseña());
        authenticationManager.authenticate(authToken);
        var usuarioAuntenticado = authenticationManager.authenticate(authToken);
        var JWToken = tokenService.generarToken((Usuario) usuarioAuntenticado.getPrincipal());
        return ResponseEntity.ok(JWToken);
    }
}
