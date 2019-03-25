package com.hackfse.fdbck.mgmt.systm.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Component;

import com.hackfse.fdbck.mgmt.systm.cnst.AppConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    /*@Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;*/
    
    @Autowired
    private Environment environment;

    public String generateToken(final Authentication authentication) {

    	final LdapUserDetailsImpl userPrincipal = (LdapUserDetailsImpl) authentication.getPrincipal();
    	final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(AppConstants.COMMA_SEPRTR));
    	
    	final Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
    	claims.put(AppConstants.AUTHORITIES_KEY, authorities);
        final Date currntDtTm = new Date();
        final Date expDtTm = new Date(currntDtTm.getTime() + 604800000);
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expDtTm)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
    
    public UsernamePasswordAuthenticationToken getAuthentication(final String token) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(jwtSecret);
        final Jws claimsJws = jwtParser.parseClaimsJws(token);
        final Claims claims = (Claims) claimsJws.getBody();
        final LdapUserDetailsImpl userPrincipal = (LdapUserDetailsImpl) claims.get(AppConstants.LDAP_USER_PRINCIPAL);

        final Collection<GrantedAuthority> authorities =
                Arrays.stream(claims.get(AppConstants.AUTHORITIES_KEY).toString().split(AppConstants.COMMA_SEPRTR))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userPrincipal, StringUtils.EMPTY, authorities);
    }
}