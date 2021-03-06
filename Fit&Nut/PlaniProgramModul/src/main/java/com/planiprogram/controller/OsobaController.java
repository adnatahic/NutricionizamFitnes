package com.planiprogram.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.planiprogram.module.Osoba;
import com.planiprogram.repository.OsobaRepository;







import org.json.JSONObject;


@RestController
@RequestMapping("/planiprogram")
public class OsobaController {
	@Autowired
	  private OsobaRepository repo;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	
	
	@RequestMapping(value="/osobe/svi", method=RequestMethod.GET)
	  public List<Osoba> VratiSveOsobe() {
	    return (List<Osoba>) repo.findAll();
	  }

	
	
	@RequestMapping(value="/osobe/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Osoba> VratiOsobuId(@PathVariable Integer id ) {
	    List<Osoba> osobe= (List<Osoba>) repo.findAll();
	    
	    for(Osoba o: osobe)
	    { 
	    	if(o.getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije pronađena osoba sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }

	
	@RequestMapping(value="/osobe/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiOsobuId(@PathVariable Integer id ) {
	    List<Osoba> osobe= (List<Osoba>) repo.findAll();
	    RestTemplate rs= new RestTemplate();
	    for(Osoba o: osobe)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		repo.delete(o);
	    		return new ResponseEntity( HttpStatus.OK);
	    	}
	    }
	    

	    return new ResponseEntity("Osoba sa traženim ID-em ne postoji.", HttpStatus.NOT_FOUND);
	  }
	
	
	@RequestMapping(value="/osobe/user/{username}", method=RequestMethod.GET)
	
	  public ResponseEntity<Osoba> VratiOsobuUsername(@PathVariable String username ) {
	    List<Osoba> osobe= (List<Osoba>) repo.findAll();
	    
	    for(Osoba o: osobe)
	    { 
	    	if(o.getUsername().equals(username)) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("No User found with username " + username, HttpStatus.NOT_FOUND);
	  }
		
	
	@RequestMapping(value="/osobe/login/{username}/{pass}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> LoginUsernamePass(@PathVariable String username, @PathVariable String pass ) {
	    List<Osoba> osobe= (List<Osoba>) repo.findAll();
	    
	    for(Osoba o: osobe)
	    { 
	    	if(o.getUsername().equals(username) && o.getPassword().equals(pass) ) return new ResponseEntity("Uspjesno logovan korisnik "+ o.getIme() + " " + o.getPrezime(), HttpStatus.OK);
	    }
	    
	    
	    return new ResponseEntity("Neispravni podaci!" , HttpStatus.NOT_FOUND);
	
	  }
	@RequestMapping(value="/osobe/dodaj/{ime}/{prezime}/{username}/{password}/{email}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> DodajOsobu(@PathVariable String ime, @PathVariable String prezime,@PathVariable String username,@PathVariable String password, @PathVariable String email ) {
	    List<Osoba> osobe= (List<Osoba>) repo.findAll();
	    System.out.println("Proslo3");
	    Osoba o = new Osoba();
	    o.setIme(ime);
	    o.setPassword(password);
	    o.setPrezime(prezime);
	    o.setUsername(username);
	    o.setEmail(email);
	    o.setId(osobe.get(osobe.size()-1).getId() +1);
	    

	    repo.save(o);
	    System.out.println("Proslo 4");
	    return new ResponseEntity(o, HttpStatus.OK);
	  }
	
	
	
	@RequestMapping(value="/osobe/update/{id}/{ime}/{prezime}/{username}/{password}/{email}", method=RequestMethod.GET)
	  public ResponseEntity<String> UpdateOsoba(@PathVariable Integer id, @PathVariable String ime, @PathVariable String prezime, @PathVariable String username, @PathVariable String password, @PathVariable String email) {
		List<Osoba> osobe= (List<Osoba>) repo.findAll();
		RestTemplate rs= new RestTemplate();
		for(Osoba o: osobe)
		{
			if(o.getId()==id)
			{
				if(!o.getIme().equals(ime)) o.setIme(ime);
				
				if(!o.getPrezime().equals(prezime)) o.setPrezime(prezime);
				
				if(!o.getPassword().equals(password)) o.setPassword(password);
				
				if(!o.getUsername().equals(username)) o.setUsername(username);
				
				if(!o.getEmail().equals(email)) o.setEmail(email);
				
				Map<String, String> vars = new HashMap<String, String>();
				vars.put("id", id.toString());
			    vars.put("ime", ime);
			    vars.put("prezime", prezime);
			    vars.put("username", username);
			    vars.put("password", password);
			    vars.put("email", email);
				
				repo.save(o);
			
				return new ResponseEntity("Uspješno update-ovana osoba sa id-em: " + o.getId(), HttpStatus.OK);
			}
		}
		
	    return new ResponseEntity("Nije pronadjena osoba sa zeljenim id-em!" , HttpStatus.NOT_FOUND);
	  }
	
}