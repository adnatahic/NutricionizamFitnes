package com.planiprogram.security;

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
//    			.antMatchers("/ishrana/svi").hasAnyAuthority("ADMIN", "KORISNIK", "TRENER")
//    			.antMatchers("/ishrana/{id}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/ishrana/izbrisi/{id}").hasAnyAuthority("ADMIN", "TRENER")
//    			.antMatchers("/ishrana/korisnik/{id}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/ishrana/dodaj/{dorucak}/{rucak}/{vecera}/{uzina1}/{uzina2}/{id}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/ishrana/update/{dorucak}/{rucak}/{vecera}/{uzina1}/{uzina2}/{id}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/komentari/svi").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/komentari/{id}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/komentari/izbrisi/{id}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/komentari/dodaj/{id_t}/{id_k}/{tekst1}").hasAnyAuthority("ADMIN", "TRENER", "KORISNIK")
//    			.antMatchers("/korisnik/svi").hasAnyAuthority("ADMIN", "TRENER")
//    			.antMatchers("/korisnik/{id}").hasAnyAuthority("ADMIN", "TRENER")
//    			.antMatchers("/korisnik/izbrisi/{id}").hasAnyAuthority("ADMIN")
//    			.antMatchers("/korisnik/dodaj/{spol}/{godine}/{visina}/{tezina}/{zeljenaTezina}/{bolesti}/{datumPristupa}/{idTrener}/{idOsoba}").hasAnyAuthority("ADMIN", "TRENER")
//    			.antMatchers("/korisnik/update/{spol}/{godine}/{visina}/{tezina}/{zeljenaTezina}/{bolesti}/{datumPristupa}/{idTrener}/{idOsoba}").hasAnyAuthority("ADMIN", "TRENER")
//    			.antMatchers("/osobe/svi").hasAnyAuthority("ADMIN")
//    			.antMatchers("/osobe/{id}").hasAnyAuthority("ADMIN")
//    			.antMatchers("/osobe/izbrisi/{id}").hasAnyAuthority("ADMIN")
//    			.antMatchers("/osobe/user/{username}").hasAuthority("ADMIN")
//    			.antMatchers("/osobe/login/{username}/{pass}").hasAuthority("ADMIN")
//    			.antMatchers("/osobe/dodaj/{ime}/{prezime}/{username}/{password}/{email}").hasAuthority("ADMIN")
//    			.antMatchers("/osobe/update/{ime}/{prezime}/{username}/{password}/{email}").hasAuthority("ADMIN")
//    			.antMatchers("/treneri/svi").hasAnyAuthority("ADMIN", "KORISNIK")
//    			.antMatchers("/treneri/{id}").hasAnyAuthority("ADMIN", "KORISNIK")
//    			.antMatchers("/treneri/izbrisi/{id}").hasAnyAuthority("ADMIN")
//    			.antMatchers("/trener/licni/{id}").hasAnyAuthority("ADMIN","TRENER", "KORISNIK")
//    			.antMatchers("/treneri/dodaj/{spol}/{godine}/{edukacija}/{iskustvo}/{brojKlijenata}/{idOsoba}").hasAnyAuthority("ADMIN")
//    			.antMatchers("/treneri/update/{spol}/{godine}/{edukacija}/{iskustvo}/{brojKlijenata}/{idOsoba}").hasAnyAuthority("ADMIN")
//    			.antMatchers("/treninzi/svi").hasAnyAuthority("ADMIN","TRENER", "KORISNIK")
    			.antMatchers("/**").permitAll()
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
