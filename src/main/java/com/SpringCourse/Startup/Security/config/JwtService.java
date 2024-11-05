package com.SpringCourse.Startup.Security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {


    private static final String SECRET_KEY="5b155ea9bd449223130edfb16e5c89d80975360f8f1368f434ab38f9ea1e5c7df6986a95d36ccb004a90de458c08346d0ee09ea3c6c518a424338cfdd5d80c42fe6f8931ed2bc3ddd2a7df03ef840ef2f3c77b1b5e1bd63cb7e7996bbc4e20b0da4ac4a91355b605bb72f3befb90d0813bde7d566af1c496b248e4781de8e32446681d42d49f6cf3b3519430da4cb235001bfc8f3e96779ec0c7fb475cee885625e569f4f3d6c1690d15ac1c365d6d148ec0acd8cee23d84ac0012fe3ff4a574c3ba906cfa07599951ad24d6b7cd3afc1487ac3dcb5ba2035b8d1302fbbd4c5e879d32be8ed56acf0f6bcae0d0135bec03e4781bd5a502164d5d426c182aa618";


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }


    public String generateToken(
            Map<String,Object> claims,
            UserDetails userDetails
    ) {
        return Jwts.builder()
                .setClaims(claims != null ? claims : new HashMap<>())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 *24 * 30))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(null,userDetails);
    }


    public boolean isTokenValid(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

}

