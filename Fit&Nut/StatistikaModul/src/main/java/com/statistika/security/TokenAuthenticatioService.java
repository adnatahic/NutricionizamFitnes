package com.statistika.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security
            .authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.statistika.module.*;
import com.statistika.module.*;
import com.statistika.repository.*;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Component
public class TokenAuthenticatioService {
	
	static OsobaRepository or;
	static KorisnikRepository kr;
	static TrenerRepository tr;
	;
	
	 static final long EXPIRATIONTIME = 864_000_000; // 10 days
	  static final String SECRET = "ThisIsASecret";
	  static final String TOKEN_PREFIX = "Bearer";
	  static final String HEADER_STRING = "Authorization";
	  
	  
	  static void addAuthentication(HttpServletResponse res, String username) {
		  
		  Osoba o = or.findByUsername(username);
		  int idOsobe = o.getId();
		  
		 
	      List<Korisnik> korisnici = (List<Korisnik>) kr.findAll();
	      List<Trener> treneri = (List<Trener>) tr.findAll();
	      
	      String rola = "";
	      
	      
	     
	      
	      for(int i = 0; i < korisnici.size(); i++)
	      {
	      	if(korisnici.get(i).getOsoba().getId() == idOsobe)
	      	{
	      		rola = "KORISNIK";
	      	}
	      }
	      
	      for(int i = 0; i < treneri.size(); i++)
	      {
	      	if(treneri.get(i).getOsoba().getId() == idOsobe)
	      	{
	      		rola = "TRENER";
	      	}
	      }
		  
	    String JWT = Jwts.builder()
	        .setSubject(username).claim("authority", rola)
	        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
	        .signWith(SignatureAlgorithm.HS512, SECRET)
	        .compact();
	    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	  }
	
	

  static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      // parse the token.
      String user = Jwts.parser()
          .setSigningKey(SECRET)
          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
          .getBody()
          .getSubject();
      
      String rola= Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.getBody()
				.get("authority").toString();
      
      System.out.println(rola);
		
		Collection<GrantedAuthority> prava = new HashSet<GrantedAuthority>();
		prava.add(new SimpleGrantedAuthority(rola));

      return user != null ?
          new UsernamePasswordAuthenticationToken(user, null, prava) :
          null;
    }
    return null;
  }
}
