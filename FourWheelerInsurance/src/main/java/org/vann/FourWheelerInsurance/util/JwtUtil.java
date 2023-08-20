package org.vann.FourWheelerInsurance.util;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.vann.FourWheelerInsurance.exceptions.JWtTokenMalformedException;
import org.vann.FourWheelerInsurance.exceptions.jwtTokenMissingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtUtil {

	final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(JwtUtil.class);

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.tokenValidity}")
	private long tokenValidity;

	public String getUserName(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			return body.getSubject();
		} catch (Exception e) {
			log.error("Cannot Get UserName from token");
			e.printStackTrace();
		}
		return null;
	}

	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Claims claims = Jwts.claims().setSubject(user.getUsername());
		long currentTimeInMills = System.currentTimeMillis();
		long expirationInMills = currentTimeInMills + tokenValidity;
		Date expDate = new Date(expirationInMills);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(currentTimeInMills)).setExpiration(expDate)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public void validateToken(final String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
		} catch (SignatureException e) {
			log.error("Invalid JWT Signature");
			throw new JWtTokenMalformedException("Invalid JWT Signature");
		} catch (ExpiredJwtException ex) {
			log.error("Invalid Expired Signature");
			throw new JWtTokenMalformedException("Expired Jwt Token");
		} catch (IllegalArgumentException ie) {
			log.error("Jwt Claims is missing Signature");
			throw new jwtTokenMissingException("Jwt Claims is missing");
		}
	}

}