package com.korisnici.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.korisnici.module.Administrator;
import com.korisnici.module.Osoba;
import com.korisnici.module.Trener;
import com.korisnici.repository.AdministratorRepository;
import com.korisnici.repository.OsobaRepository;

@RestController
@RequestMapping("/korisnici")
public class AdministratorController {
	@Autowired
	  private AdministratorRepository repo;
	private OsobaRepository repoo;
	
	@RequestMapping(value="/administrator/svi", method=RequestMethod.GET)
	  public List<Administrator> AdministratoriSvi() {
	    return (List<Administrator>) repo.findAll();
	  }
	
	@RequestMapping(value="/administrator/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Administrator> VratiAdministratoraId(@PathVariable Integer id ) {
	    List<Administrator> osobe= (List<Administrator>) repo.findAll();
	    
	    for(Administrator o: osobe)
	    { 
	    	if(o.getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije pronađena osoba sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/administrator/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiOsobuId(@PathVariable Integer id ) {
	    List<Administrator> osobe= (List<Administrator>) repo.findAll();
	    
	    for(Administrator o: osobe)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		repo.delete(o);
	    		return new ResponseEntity("Uspješno izbrisana osoba sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađena osoba sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	

	@RequestMapping(value="/administrator/dodaj/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> DodajAdmin(@PathVariable Integer idOsoba ) {
	    List<Administrator> admini= (List<Administrator>) repo.findAll();
	    List<Osoba> osobe= (List<Osoba>) repoo.findAll();
	    for(Osoba o: osobe)
	    {
	    	if(o.getId()==idOsoba)
	    	{
	    		Administrator novi= new Administrator();
	    		novi.setOsoba(o);
	    		
	    		repo.save(novi);
	    	
	    		return new ResponseEntity("Uspješno kreiran administrator!" , HttpStatus.OK);
	    		
	    	}
	    }
	   
	  return new ResponseEntity("Administrator nije kreiran!" , HttpStatus.NOT_FOUND);
	  
	}
	
	
	@RequestMapping(value="/administrator/update/{id}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> UpdateAdmin(@PathVariable Integer id, @PathVariable Integer idOsoba ) {
	    List<Administrator> admini= (List<Administrator>) repo.findAll();
	    List<Osoba> osobe= (List<Osoba>) repoo.findAll();
	    for(Administrator a: admini)
	    {
	    	if(a.getId()==id)
	    	{
	    		for(Osoba o:osobe)
	    		{
	    			if(o.getId()==idOsoba)
	    			{
	    				a.setOsoba(o);
	    			  repo.save(a);
	    	    	
	    	    		return new ResponseEntity("Uspješno kreiran administrator!" , HttpStatus.OK);
	    	    	
	    				
	    			}
	    		}
	    	}
	    	
	    }
	    
	    return new ResponseEntity("Administrator nije izmjenjen!" , HttpStatus.NOT_FOUND);
	  }

}
