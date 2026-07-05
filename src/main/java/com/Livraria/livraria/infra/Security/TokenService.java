package com.Livraria.livraria.infra.Security;

import com.Livraria.livraria.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String getToken(UserEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("MySecret");

            return JWT.create()
                    .withIssuer("my aplication")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genDate())
                    .sign(algorithm);
        } catch (JWTCreationException error) {
            throw new RuntimeException(error);
        }
    }

    public Instant genDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
       try {
           Algorithm algorithm = Algorithm.HMAC256("MySecret");
           return JWT.require(algorithm)
                   .withIssuer("my aplication")
                   .build()
                   .verify(token)
                   .getSubject();

       } catch (JWTVerificationException e) {
           return "";
       }

    }
}
