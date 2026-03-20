package com.flarecon.AirPulse.utils.jwt;

import com.flarecon.AirPulse.spring.security.AuthService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET;
    private static final int TOKEN_EXPIRATION_HOURS = 18;
    private final SecretKey JWT_KEY;

    private final AuthService authService;

    public JwtUtil(@Value("${jwt.secret}") String secret, AuthService authService) {
        this.SECRET = secret;
        this.JWT_KEY = Keys.hmacShaKeyFor(secret.getBytes());
        this.authService = authService;
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * TOKEN_EXPIRATION_HOURS))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    // TODO: implement extractor and validator for jwt tokens

    public String checkExpirationAndExtractUsername(String token) {
        if (token == null) return null;

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_KEY).build()
                .parseClaimsJws(token).getBody();

        if (claims.getExpiration().before(new Date())) return null;
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        return authService.authenticateUsername(checkExpirationAndExtractUsername(token));
    }
}
