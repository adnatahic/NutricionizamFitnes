package com.planiprogram.controller;

import java.util.Date;
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


import com.planiprogram.module.Korisnik;
import com.planiprogram.module.Osoba;
import com.planiprogram.module.Trener;
import com.planiprogram.repository.KorisnikRepository;
import com.planiprogram.repository.OsobaRepository;
import com.planiprogram.repository.TrenerRepository;

@RestController
@RequestMapping("/planiprogram")
public class KorisnikController {
	@Autowired
	  private KorisnikRepository repo;
	private OsobaRepository repoo;
	private TrenerRepository repot;
	
	@RequestMapping(value="/korisnik/svi",method=RequestMethod.GET)
	
	  public List<Korisnik> getAll() {
	    return (List<Korisnik>) repo.findAll();
	  }
	
	@RequestMapping(value="/korisnik/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Korisnik> VratiKorisnikaId(@PathVariable Integer id ) {
	    List<Korisnik> korisnici= (List<Korisnik>) repo.findAll();
	    
	    for(Korisnik o: korisnici)
	    { 
	    	if(o.getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/korisnik/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiKorisnikaId(@PathVariable Integer id ) {
	    List<Korisnik> korisnici= (List<Korisnik>) repo.findAll();
	    
	    for(Korisnik o: korisnici)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    			repo.delete(o);
	    		return new ResponseEntity("Uspješno izbrisan korisnik sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/korisnik/dodaj/{spol}/{godine}/{visina}/{tezina}/{zeljenaTezina}/{bolesti}/{datumPristupa}/{idTrener}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<String> DodajKorisnika(@PathVariable String spol, @PathVariable Integer godine, @PathVariable Integer visina, 
			  @PathVariable Integer tezina, @PathVariable Integer zeljenaTezina, @PathVariable String bolesti, @PathVariable Date datumPristupa,
			  @PathVariable Integer idTrener, @PathVariable Integer idOsoba) {
		
		List<Korisnik> korisnici= (List<Korisnik>) repo.findAll();
		List<Osoba> osobe= (List<Osoba>) repoo.findAll();
		List<Trener> treneri= (List<Trener>) repot.findAll();
		
		for(Korisnik k: korisnici)
		{
			if(k.getOsoba().getId()==idOsoba)
			{
				return new ResponseEntity("Postoji korisnik sa željenim ID-em! " , HttpStatus.NOT_FOUND);
			}
		}
		Korisnik novi= new Korisnik();
		Trener pom= new Trener();
		for (Trener t: treneri)
		{
			if(t.getId()==idTrener)
			{
				novi.setTrener(t);
			}
		}
		
		
		for(Osoba o: osobe)
		{
			if(o.getId()==idOsoba)
			{
				if(novi.getTrener()== null)
				{
					return new ResponseEntity("Trener ne postoji! " , HttpStatus.NOT_FOUND);
				}
				novi.setOsoba(o);
				novi.setBolesti(bolesti);
				novi.setSpol(spol);
				novi.setGodine(godine);
				novi.setVisina(visina);
				novi.setTezina(tezina);
				novi.setZeljenaTezina(zeljenaTezina);
				novi.setDatumPristupa(datumPristupa);
				
				repo.save(novi);
				
				
			}
		}
		
		
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " , HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/korisnik/update/{id}/{spol}/{godine}/{visina}/{tezina}/{zeljenaTezina}/{bolesti}/{datumPristupa}/{idTrener}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<String> UpdateKorisnika(@PathVariable Integer id, @PathVariable String spol, @PathVariable Integer godine, @PathVariable Integer visina, 
			  @PathVariable Integer tezina, @PathVariable Integer zeljenaTezina, @PathVariable String bolesti, @PathVariable Date datumPristupa,
			  @PathVariable Integer idTrener, @PathVariable Integer idOsoba) {
		
		List<Korisnik> korisnici= (List<Korisnik>) repo.findAll();
		List<Osoba> osobe= (List<Osoba>) repoo.findAll();
		List<Trener> treneri= (List<Trener>) repot.findAll();
			Osoba pom= new Osoba();
		
		for(Korisnik k: korisnici)
		{
			if(k.getOsoba().getId()==idOsoba && k.getId()!=id)
			{
				return new ResponseEntity("Postoji korisnik sa željenim ID-em! " , HttpStatus.NOT_FOUND);
			}
			
		}
		
		for(Korisnik o: korisnici)
		{
			if(o.getId()==id)
			{
				for(Osoba os: osobe)
				{
					if(os.getId()==idOsoba)
					{
						o.setOsoba(os);
					}
						
				}
			
				for (Trener t: treneri)
				{
					if(t.getId()==idTrener)
					{
						o.setTrener(t);
					}
				}
				
				if(!o.getSpol().equals(spol)) o.setSpol(spol);
				if(o.getGodine()!=godine) o.setGodine(godine);
				if(o.getVisina()!=visina) o.setVisina(visina);
				if(o.getTezina()!=tezina) o.setTezina(tezina);
				if(o.getZeljenaTezina()!=zeljenaTezina) o.setZeljenaTezina(zeljenaTezina);
				if(!o.getBolesti().equals(bolesti)) o.setBolesti(bolesti);
				if(!o.getDatumPristupa().toString().equals(datumPristupa.toString())) o.setDatumPristupa(datumPristupa);
				
				
				repo.save(o);
				
	    		 return new ResponseEntity("Uspješan update! " , HttpStatus.OK);
			}
		}
		
		
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " , HttpStatus.NOT_FOUND);
	  }
	
	
}