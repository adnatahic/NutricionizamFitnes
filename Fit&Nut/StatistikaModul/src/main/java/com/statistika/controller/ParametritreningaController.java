package com.statistika.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.statistika.module.Korisnik;
import com.statistika.module.Osoba;
import com.statistika.module.Parametritreninga;
import com.statistika.repository.KorisnikRepository;
import com.statistika.repository.ParametritreningaRepository;

@RestController
@RequestMapping("/statistika")
public class ParametritreningaController {
	@Autowired
	  private ParametritreningaRepository repo;
	@Autowired
	private KorisnikRepository repok;
	
	@RequestMapping(value="/parametri/svi",method=RequestMethod.GET)
	  public List<Parametritreninga> ParametriSvi() {
	    return (List<Parametritreninga>) repo.findAll();
	  }
	
	@RequestMapping(value="/parametri/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Parametritreninga> VratiParametreId(@PathVariable Integer id ) {
	    List<Parametritreninga> osobe= (List<Parametritreninga>) repo.findAll();
	    
	    for(Parametritreninga o: osobe)
	    { 
	    	if(o.getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije pronađen parametar treninga sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }

	@RequestMapping(value="/parametri/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiParametarId(@PathVariable Integer id ) {
	    List<Parametritreninga> osobe= (List<Parametritreninga>) repo.findAll();
	    
	    for(Parametritreninga o: osobe)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		repo.delete(id);
	    		return new ResponseEntity("Uspješno izbrisan parametar treninga sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađen parametar treninga sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="osobe/dodaj/{id_k}/{tezina}", method=RequestMethod.GET)
	  public ResponseEntity<Parametritreninga> DodajOsobu(@PathVariable int id_k, @PathVariable int tezina) {
	    List<Parametritreninga> osobe= (List<Parametritreninga>) repo.findAll();
	    
	    int velicina= osobe.size();
	    Parametritreninga p= new Parametritreninga();
	    List<Korisnik> korisnici= (List<Korisnik>) repok.findAll();
	    for(Korisnik k: korisnici)
	    {
	    	if(k.getId()==id_k)
	    	{
	    		p.setKorisnik(k);
	    	}
	    }
	    p.setId(osobe.get(velicina-1).getId()+1);
	    p.setTezina(tezina);
	    p.setDatum(new Date());
	    
	    repo.save(p);
	    
	    return new ResponseEntity("Uspješno dodan parametar!" , HttpStatus.OK);
	  }
	
}
