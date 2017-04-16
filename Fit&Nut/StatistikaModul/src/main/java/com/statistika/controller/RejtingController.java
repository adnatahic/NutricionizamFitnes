package com.statistika.controller;


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
import com.statistika.module.Rejting;
import com.statistika.module.Trener;
import com.statistika.repository.KorisnikRepository;
import com.statistika.repository.OsobaRepository;
import com.statistika.repository.RejtingRepository;
import com.statistika.repository.TrenerRepository;

@RestController
@RequestMapping("/statistika")
public class RejtingController {
	@Autowired
	  private RejtingRepository repo;
	private TrenerRepository repot;
	private KorisnikRepository repok;
	
	@RequestMapping(value="/rejting/svi",method=RequestMethod.GET)
	  public List<Rejting> RejtingSvi() {
	    return (List<Rejting>) repo.findAll();
	  }
	
	@RequestMapping(value="/rejting/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiRejtingId(@PathVariable Integer id ) {
	    List<Rejting> rejting= (List<Rejting>) repo.findAll();
	    
	    for(Rejting o: rejting)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		repo.delete(id);
	    		return new ResponseEntity("Uspješno izbrisan rejting sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađen rejting sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="rejting/dodaj/{id_k}/{id_t}/{ocjena}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> DodajRejting(@PathVariable int id_k, @PathVariable int id_t,@PathVariable int ocjena) {
	    List<Rejting> osobe= (List<Rejting>) repo.findAll();
	    
	    List<Trener> treneri= (List<Trener>) repot.findAll();
	    List<Korisnik> korisnici= (List<Korisnik>) repok.findAll();
	    
	    Rejting k= new Rejting();
	    for(Trener t: treneri)
	    {
	    	if(t.getId()==id_t)
	    	{
	    		k.setTrener(t);
	    	}	
	    }
	    
	    for(Korisnik ko: korisnici)
	    {
	    	if(ko.getId()==id_k)
	    	{
	    		k.setKorisnik(ko);
	    	}
	    }
	    
	    if(ocjena>0) k.setOcjena(ocjena);
	    
	    if(k.getKorisnik()!=null && k.getTrener()!=null && ocjena>0)
	    {
	    	repo.save(k);
	    	return new ResponseEntity("Uspješno ocjenjen trener!" , HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nisu ispravni podaci!" , HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="rejting/update/{id}/{id_k}/{id_t}/{ocjena}", method=RequestMethod.GET)
	  public ResponseEntity<String> UpdateRejting(@PathVariable int id,@PathVariable int id_k, @PathVariable int id_t,@PathVariable int ocjena) {
		List<Rejting> rejting= (List<Rejting>) repo.findAll();
		 List<Trener> treneri= (List<Trener>) repot.findAll();
		    List<Korisnik> korisnici= (List<Korisnik>) repok.findAll();
		    
		   
		    
		   
		for(Rejting o: rejting)
		{
			if(o.getId()==id)
			{
				if(o.getKorisnik().getId()!=id_k)
				{
					for(Korisnik ko: korisnici)
				    {
				    	if(ko.getId()==id_k)
				    	{
				    		o.setKorisnik(ko);
				    	}
				    }
				}
				if(o.getTrener().getId()!=id_t)
				{
					 for(Trener t: treneri)
					    {
					    	if(t.getId()==id_t)
					    	{
					    		o.setTrener(t);
					    	}	
					    }
				}
				if(ocjena!=o.getOcjena() && ocjena>0)
				{
					o.setOcjena(ocjena);
				}
				repo.save(o);
				
				return new ResponseEntity("Uspješno update-ovan rejting sa id-em: " + o.getId(), HttpStatus.OK);
			}
		}
		
	    return new ResponseEntity("Nije pronadjen rejting sa zeljenim id-em!" , HttpStatus.NOT_FOUND);
	  }

}
