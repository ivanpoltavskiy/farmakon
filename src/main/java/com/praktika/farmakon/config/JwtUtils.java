package com.praktika.farmakon.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final UserDetailsService userDetailsService;

    private static final String secretKey = "21312KFDkdf32DS29321123jioS";
    private static final Duration jwtLifeTime = Duration.ofMinutes(60);

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean hasClaim(String token, String claimName) {
        final Claims claims = extractAllClaims(token);
        return claims.get(claimName) != null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(    token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails);
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> claims){
        return createToken(claims, userDetails);
    }

    public String createToken(Map<String, Object> claims, UserDetails userDetails){
        return Jwts.builder().setClaims(claims)
                .setSubject(userDetails.getUsername())
                .claim("authorities", userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtLifeTime.toMillis()))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }


//    public String generateToken(User user){
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("name", user.getName());
//        claims.put("surname", user.getSurname());
//        claims.put("dateOfBirthday", user.getDateOfBirthday());
//        claims.put("email", user.getEmail());
//        claims.put("roles", user.getRoles());
//
//        return buildToken(claims, user);
//    }
//
//    public String buildToken(Map<String, Object> claims, User user){
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
//        Date issueDate = new Date();
//        Date expiredDate = new Date(issueDate.getTime() + jwtLifeTime.toMillis());
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(issueDate)
//                .setExpiration(expiredDate)
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
}
