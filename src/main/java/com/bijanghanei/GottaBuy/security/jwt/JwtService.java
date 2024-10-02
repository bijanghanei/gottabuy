package com.bijanghanei.GottaBuy.security.jwt;

import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class JwtService {
    @Autowired
    private GottaBuyUserRepository userRepository;
    private final static int BEARER_LENGTH = 7;
    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;
    private static final long jwtExpMillis = TimeUnit.MINUTES.toMillis(30);
    public String generateToken(UserDetails details) {

        /**
         * providing custom info  we want by adding claims
         */
        Map<String, String> claims = new HashMap<>();
        claims.put("iss", "gottabuy.com");
        return Jwts.builder()
                .claims(claims)
                .subject(details.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(jwtExpMillis)))
                .signWith(generateKey())
                .compact();
    }

    public SecretKey generateKey() {
        byte[] decoded = Base64.getDecoder().decode(jwtSecret);
        return Keys.hmacShaKeyFor(decoded);
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(this.generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public String extractUsername(String token) {
        return this.getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("This token is expired {}" , e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid token {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("Token claims is empty {}", e.getMessage());
        }
        return false;
    }

    public String getJwtFromHeader(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        log.debug("Authorization header : {}", bearer);
        if (bearer == null || !bearer.startsWith("Bearer ")) {
            return null;
        }
        return bearer.substring(BEARER_LENGTH);
    }
    public GottaBuyUser extractUser(HttpServletRequest request) {
        String jwt = this.getJwtFromHeader(request);
        String username = this.extractUsername(jwt);
        return userRepository.findByUsername(username);
    }
}
