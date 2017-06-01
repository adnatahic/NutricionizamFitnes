package com.statistika.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
    			.antMatchers("/osobe/*").hasAuthority("ADMIN")
    			.antMatchers("/korisnik/*").hasAuthority("ADMIN")
    		 	.antMatchers("/treneri/svi").hasAnyAuthority("ADMIN","KORISNIK")
    		 	.antMatchers("/treneri/{id}").hasAnyAuthority("ADMIN")
    		 	.antMatchers("/treneri/izbrisi/{id}").hasAnyAuthority("ADMIN")
    		 	.antMatchers("/treneri/klijent/{id}").hasAnyAuthority("ADMIN","TRENER")
    		 	.antMatchers("/treneri/licni/{id}").hasAnyAuthority("ADMIN","TRENER")
    		 	.antMatchers("/treneri/dodaj/{spol}/{godine}/{edukacija}/{iskustvo}/{brojKlijenata}/{idOsoba}").hasAuthority("ADMIN")
    		 	.antMatchers("/treneri/update/{spol}/{godine}/{edukacija}/{iskustvo}/{brojKlijenata}/{idOsoba}").hasAuthority("ADMIN")
    		 	.antMatchers("/parametri/svi").hasAnyAuthority("ADMIN","KORISNIK","TRENER")
    		 	.antMatchers("/parametri/{id}").hasAnyAuthority("ADMIN","KORISNIK","TRENER")
    		 	.antMatchers("/parametri/izbrisi/{id}").hasAnyAuthority("ADMIN","TRENER")
    		 	.antMatchers("/osobe/dodaj/{id_k}/tezina").hasAnyAuthority("ADMIN","TRENER")
    		 	.antMatchers("/parametri/{id}").hasAnyAuthority("ADMIN","KORISNIK","TRENER")
    		 	.antMatchers("/rejting/svi").hasAnyAuthority("ADMIN","KORISNIK","TRENER")
    		 	.antMatchers("/rejting/izbrisi/{id}").hasAnyAuthority("ADMIN")
    		 	.antMatchers("/rejting/dodaj/{id_k}/{id_t}/{ocjena}").hasAnyAuthority("ADMIN","KORISNIK")
    		 	
    		 	
    		 	.antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .anyRequest().authenticated()
        .and()
        // We filter the api/login requests
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
        // And filter other requests to check the presence of JWT in header
        .addFilterBefore(new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
  }

  /*@Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Create a default account
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("password")
        .roles("ADMIN");
    
    auth.inMemoryAuthentication()
    .withUser("trener")
    .password("trener")
    .roles("TRENER");
    
    auth.inMemoryAuthentication()
    .withUser("korisnik")
    .password("korisnik")
    .roles("KORISNIK");
  }*/
  
  @Autowired
  	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  	       auth.userDetailsService(userDetailsService);
  	  }
  
}
