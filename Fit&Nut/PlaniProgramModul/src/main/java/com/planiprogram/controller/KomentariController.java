package com.planiprogram.controller;

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

import com.planiprogram.module.Ishrana;
import com.planiprogram.module.Komentari;
import com.planiprogram.module.Korisnik;
import com.planiprogram.module.Osoba;
import com.planiprogram.module.Trener;
import com.planiprogram.repository.IshranaRepository;
import com.planiprogram.repository.KomentariRepository;
import com.planiprogram.repository.KorisnikRepository;
import com.planiprogram.repository.TrenerRepository;

@RestController
@RequestMapping("/planiprogram")
public class KomentariController {
	@Autowired
	  private KomentariRepository repo;
	private TrenerRepository repot;
	private KorisnikRepository repok;
	
	@RequestMapping(value="/komentari/svi", method=RequestMethod.GET)
	  public List<Komentari> VratiSveKomentare() {
	    return (List<Komentari>) repo.findAll();
	  }
	
	@RequestMapping(value="/komentari/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Komentari> VratiKomentarId(@PathVariable Integer id ) {
	    List<Komentari> komentari= (List<Komentari>) repo.findAll();
	    
	    for(Komentari o: komentari)
	    { 
	    	if(o.getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije pronađen komentar sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/komentari/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiKomentarId(@PathVariable Integer id ) {
	    List<Komentari> osobe= (List<Komentari>) repo.findAll();
	    
	    for(Komentari o: osobe)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		repo.delete(id);
	    		return new ResponseEntity("Uspješno izbrisan komentar sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađen komentar sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="komentari/dodaj/{id_t}/{id_k}/{tekst1}", method=RequestMethod.GET)
	  public ResponseEntity<Komentari> DodajKomentar(@PathVariable Integer id_t, @PathVariable Integer id_k,@PathVariable String tekst1) {
	    List<Komentari> komentari= (List<Komentari>) repo.findAll();
	    List<Trener> treneri= (List<Trener>) repot.findAll();
	    List<Korisnik> korisnici= (List<Korisnik>) repok.findAll();
	    Komentari k= new Komentari();
	    
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
	    k.setTekst(tekst1);
	    k.setId(komentari.get(komentari.size()-1).getId()+1 );
	    
	    if(k.getTrener()!= null && k.getKorisnik()!=null && k.getTekst()!=null)
	    {
	    	Date d= new Date();
	    	k.setDatum(d);
	    	repo.save(k);
		    return new ResponseEntity("Uspješno kreiran komentar!" , HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije kreiran komentar! Provjerite parametre." , HttpStatus.NOT_FOUND);
	  }
	
}
