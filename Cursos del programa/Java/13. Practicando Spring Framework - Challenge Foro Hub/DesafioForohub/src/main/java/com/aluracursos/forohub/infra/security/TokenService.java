package com.aluracursos.forohub.infra.security;

import com.aluracursos.forohub.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@Service
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class TokenService {
    @Value("${api.security.secret}")
    private String apiSecret;
    @Value("${api.security.token-duration}")
    private int tokenDuration;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); //
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(usuario.getNombre())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(tokenDuration).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String token) {
        DecodedJWT decodedJWT = validateToken(token);
        return decodedJWT.getSubject().toString();
    }

    public DecodedJWT validateToken(String token){
        if (token == null || token == "")
            throw new RuntimeException("El token es nulo");
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("forohub")
                    .build();
            return verifier.verify(token);
        } catch(JWTVerificationException e){
            throw e;
        }
    }

}
