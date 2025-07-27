package com.jimmyproject.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@RequiredArgsConstructor
@Service
@Slf4j
public class JwtTokenService {
    private final JwtProperties jwtProperties;

    /// Generate a JWT token
    public String generateJwtToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    /// Generate token with claims
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();


    }

    public String extractUsernameFromJwt(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    /// Extract expiration date from JWT token
    public Date extractExpirationDateFromJwt(String jwt) {
        return extractClaim(jwt, Claims::getExpiration);
    }

    /// Extract a specific claim
    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    /// Extract all claims from JWT token
    public Claims extractAllClaims(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    /// Get the signing key
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
    }

    /// Validate if token is valid for a given user
    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUsernameFromJwt(jwt);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }

    //Check if token is expired
    private boolean isTokenExpired(String token) {
        return extractExpirationDateFromJwt(token).before(new Date());
    }

    /// Generate refresh token
    public String generateRefreshToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Long getExpirationTime() {return jwtProperties.getExpiration();}
}
