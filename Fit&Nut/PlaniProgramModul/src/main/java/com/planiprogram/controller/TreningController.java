package com.planiprogram.controller;

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

import com.planiprogram.module.Korisnik;
import com.planiprogram.module.Osoba;
import com.planiprogram.module.Trener;
import com.planiprogram.module.Trening;
import com.planiprogram.repository.KorisnikRepository;
import com.planiprogram.repository.TreningRepository;

@RestController
@RequestMapping("/planiprogram")
public class TreningController {
	@Autowired
	  private TreningRepository repo;
	
	@Autowired
	private KorisnikRepository repok;
	
	@RequestMapping(value="/treninzi/svi",method=RequestMethod.GET)
	  public List<Trening> getAll() {
	    return (List<Trening>) repo.findAll();
	  }
	
	@RequestMapping(value="/treninzi/dodaj/{idKorisnik}/{trajanje}/{vrsta}/{opis}", method=RequestMethod.GET)
	  public ResponseEntity<Trening> DodajTrening(@PathVariable Integer idKorisnik,
			  @PathVariable Integer trajanje, 
			  @PathVariable String vrsta, @PathVariable String opis ) {
	 
		List<Trening> treninzi= (List<Trening>) repo.findAll();
	   Korisnik k= repok.findOne(idKorisnik);
	   if(k!=null)
	   {
		   Trening t= new Trening();
		   t.setId( treninzi.get(treninzi.size()-1 ).getId()+1 );
		   t.setKorisnik(k);
		   t.setOpis(opis);
		   t.setTrajanje(trajanje);
		   t.setVrsta(vrsta);
		   repo.save(t);
		   return new ResponseEntity(t , HttpStatus.OK);
	   }
	  
	    return new ResponseEntity("Greška- planiprogram!" , HttpStatus.NOT_FOUND);
	   
	  }
	

}
