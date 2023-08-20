package org.vann.FourWheelerInsurance.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.vann.FourWheelerInsurance.exceptions.jwtTokenMissingException;
import org.vann.FourWheelerInsurance.services.CustomerAuthenticationService;
import org.vann.FourWheelerInsurance.services.PolicyService;
import org.vann.FourWheelerInsurance.util.JwtUtil;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{

final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(JwtAuthenticationFilter.class);

@Autowired
private JwtUtil jwtUtil;
@Autowired
private CustomerAuthenticationService customerAuthenticationService;
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
throws ServletException, IOException {

String header = request.getHeader("Authorization");
if(header == null || ! header.startsWith("HTTP_TOKEN"))
{
log.error("No JWT Token Found in the Request sent by customer");
throw new jwtTokenMissingException("No Jwt Token Found in the request");
}
String token = header.substring("HTTP_TOKEN".length()+1);
jwtUtil.validateToken(token);
String username = jwtUtil.getUserName(token);
UserDetails userDetails = customerAuthenticationService.loadUserByUsername(username);
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
if(SecurityContextHolder.getContext().getAuthentication() == null) {
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
filterChain.doFilter(request, response);
}



}
