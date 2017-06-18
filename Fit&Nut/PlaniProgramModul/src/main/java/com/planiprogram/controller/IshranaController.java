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
import org.springframework.web.client.RestTemplate;

import com.planiprogram.module.Ishrana;
import com.planiprogram.module.Korisnik;
import com.planiprogram.module.Osoba;
import com.planiprogram.repository.IshranaRepository;
import com.planiprogram.repository.KorisnikRepository;

@RestController
@RequestMapping("/planiprogram")
public class IshranaController {
	@Autowired
	private IshranaRepository repo;
	@Autowired
	private KorisnikRepository repo_korisnici;
	
	@RequestMapping(value="/ishrana/svi", method=RequestMethod.GET)
	  public List<Ishrana> IshranaSvi() {
	    return (List<Ishrana>) repo.findAll();
	  }
	
	@RequestMapping(value="/ishrana/{id}", method=RequestMethod.GET)
	  public ResponseEntity<Ishrana> VratiIshranuId(@PathVariable Integer id ) {
	    List<Ishrana> ishrana= (List<Ishrana>) repo.findAll();
	    
	    for(Ishrana o: ishrana)
	    { 
	    	if(o.getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nije pronađena ishrana sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/ishrana/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiIshranuId(@PathVariable Integer id ) {
	    List<Ishrana> ishrana= (List<Ishrana>) repo.findAll();
	    
	    for(Ishrana o: ishrana)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		RestTemplate rs= new RestTemplate();
	    		
	    		repo.delete(o);
	    		return new ResponseEntity("Uspješno izbrisana ishrana." + id, HttpStatus.OK);

	    	}
	    }
	    return new ResponseEntity("Nije pronađena osoba sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/ishrana/korisnik/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Ishrana> VratiIshranuKorisnik(@PathVariable Integer id ) {
	    List<Ishrana> ishrana= (List<Ishrana>) repo.findAll();
	    
	    for(Ishrana o: ishrana)
	    { 
	    	if(o.getKorisnik().getId()==id) return new ResponseEntity(o, HttpStatus.OK);
	    }
	    
	    return new ResponseEntity("Nema ishrane za traženog korisnika " , HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="ishrana/dodaj/{dorucak}/{rucak}/{vecera}/{uzina1}/{uzina2}/{id}", method=RequestMethod.GET)
	  public ResponseEntity<Ishrana> DodajIshranu(@PathVariable String dorucak, @PathVariable String rucak,
			  @PathVariable String vecera,@PathVariable String uzina1, @PathVariable String uzina2, 
			  @PathVariable int id ) {
	    
		List<Ishrana> ishrane= (List<Ishrana>) repo.findAll();
		List<Korisnik> korisnici= (List<Korisnik>) repo_korisnici.findAll();
		Ishrana i= new Ishrana();
		for (Korisnik k: korisnici)
		{
			if(k.getId()==id)
			{
				i.setId(ishrane.get(ishrane.size()-1).getId() +1);
				i.setDorucak(dorucak);
				i.setRucak(rucak);
				i.setVecera(vecera);
				i.setUzina1(uzina1);
				i.setUzina2(uzina2);
				i.setKorisnik(k);
				
				repo.save(i);
			    return new ResponseEntity(i , HttpStatus.OK);
			}
		}
	   
		 return new ResponseEntity("Nije pronađen željeni korisnik!" , HttpStatus.NOT_FOUND);
	    
	    
	  }
	
	@RequestMapping(value="ishrana/update/{id}/{dorucak}/{rucak}/{vecera}/{uzina1}/{uzina2}/{id1}", method=RequestMethod.GET)
	  public ResponseEntity<String> UpdateIshrana(@PathVariable Integer id,@PathVariable String dorucak, @PathVariable String rucak,@PathVariable String vecera,@PathVariable String uzina1, @PathVariable String uzina2, @PathVariable int id1) {
		List<Ishrana> ishrana= (List<Ishrana>) repo.findAll();
		
		for(Ishrana o: ishrana)
		{
			if(o.getId()==id)
			{
				if(!o.getDorucak().equals(dorucak)) o.setDorucak(dorucak);
				
				if(!o.getRucak().equals(rucak)) o.setRucak(rucak);
				
				if(!o.getVecera().equals(vecera)) o.setVecera(vecera);
				
				if(!o.getUzina1().equals(uzina1)) o.setUzina1(uzina1);
				
				if(!o.getUzina2().equals(uzina2)) o.setUzina1(uzina2);
				
				if(o.getKorisnik().getId()!=id1)
				{
					List<Korisnik> korisnici= (List<Korisnik>) repo_korisnici.findAll();
					for(Korisnik k: korisnici)
					{
						if(k.getId()==id)
						{
							o.setKorisnik(k);
							repo.save(o);
							return new ResponseEntity("Uspješno update-ovana osoba sa id-em: " + o.getId(), HttpStatus.OK);
						}
					}
					return new ResponseEntity("Nije pronađen korisnik sa tim id-em! " , HttpStatus.NOT_FOUND);
					
				}
				
				repo.save(o);
				return new ResponseEntity("Uspješno update-ovana osoba sa id-em: " + o.getId(), HttpStatus.OK);
				
			}
		}
		
	    return new ResponseEntity("Nije pronađena ishrana sa željenim id-em!" , HttpStatus.NOT_FOUND);
	  }

}
