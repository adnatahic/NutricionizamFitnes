package com.statistika.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.statistika.module.Korisnik;
import com.statistika.module.Osoba;
import com.statistika.module.Trener;
import com.statistika.repository.KorisnikRepository;
import com.statistika.repository.OsobaRepository;
import com.statistika.repository.TrenerRepository;

@RestController
@RequestMapping("/statistika")
public class TrenerController {
	@Autowired
	private TrenerRepository repo;
	@Autowired
	private KorisnikRepository repok;
	@Autowired
	private OsobaRepository repoo;
	
	@RequestMapping(value="/treneri/svi", method=RequestMethod.GET)
	  public List<Trener> VratiSveTrenere() {
	    return (List<Trener>) repo.findAll();
	  }
	
	@RequestMapping(value="/treneri/{id}", method=RequestMethod.GET)
	
	  public ResponseEntity<Trener> VratiTreneraId(@PathVariable Integer id ) {
	    List<Trener> treneri= (List<Trener>) repo.findAll();
	    
	    for(Trener o: treneri)
	    { 
	    	if(o.getId()==id) 
	    	{
	    		return new ResponseEntity(o , HttpStatus.OK);
	    	}	    	
	    }
	    
	    return new ResponseEntity("Nije pronađen trener sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }

	@RequestMapping(value="/treneri/izbrisi/{id}", method=RequestMethod.GET)
	  public ResponseEntity<String> izbrisiTreneraId(@PathVariable Integer id ) {
	    List<Trener> treneri= (List<Trener>) repo.findAll();
	    RestTemplate rs= new RestTemplate();
	    for(Trener o: treneri)
	    { 
	    	if(o.getId()==id) 
	    	{ 
	    		
	    		//String rez= rs.getForObject("http://localhost:8082/planiprogram/treneri/izbrisi/{id}", String.class, id);
	    		//String rez2= rs.getForObject("http://localhost:8083/statistika/treneri/izbrisi/{id}", String.class, id);
	    		repo.delete(o);
	    		return new ResponseEntity("Uspješno izbrisan trener sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađen trener sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/treneri/klijent/{id}", method=RequestMethod.GET)
	  public ResponseEntity<Trener> VratiTreneraKlijenta(@PathVariable int id ) {
	    List<Trener> treneri= (List<Trener>) repo.findAll();
	    List<Korisnik> korisnici= (List<Korisnik>) repok.findAll();
	    
	    for(Korisnik k: korisnici)
	    { 
	    	if(k.getId()==id)
	    	{
	    		return new ResponseEntity(k.getTrener(), HttpStatus.OK);
	    	}
	    }
	    
	    return new ResponseEntity("Nije pronađen trener traženog klijenta." , HttpStatus.NOT_FOUND);
	    
	  }
	
	@RequestMapping(value="/treneri/licni/{id}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> VratiPodatkeTrenera(@PathVariable Integer id ) {
	    List<Trener> treneri= (List<Trener>) repo.findAll();
	    
	    for(Trener o: treneri)
	    { 
	    	if(o.getId()==id)
	    	{
	    		return new ResponseEntity(o.getOsoba(), HttpStatus.NOT_FOUND);
	    	}
	    }
	    
	    return new ResponseEntity("Nije pronađen trener traženog klijenta." , HttpStatus.NOT_FOUND);
	    
	  }
	
	@RequestMapping(value="/treneri/dodaj/{spol}/{godine}/{edukacija}/{iskustvo}/{brojKlijenata}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<Osoba> DodajTrenera(@PathVariable String spol, @PathVariable Integer godine,
			  @PathVariable String edukacija,@PathVariable Integer iskustvo, 
			  @PathVariable Integer brojKlijenata, @PathVariable Integer idOsoba ) {
	    List<Trener> treneri= (List<Trener>) repo.findAll();
	    
	    System.out.println("Prošlo 1");
	   Osoba osob= repoo.findOne(idOsoba);
	   
	    if(osob!=null)
	    {
	    	System.out.println("Prošlo 2");
	    int velicina= treneri.size();
	    		 Trener o = new Trener();
	    		    o.setBrojKlijenata(brojKlijenata);
	    		    o.setEdukacija(edukacija);
	    		    o.setGodine(godine);
	    		    o.setIskustvo(iskustvo);
	    		    o.setOsoba(osob);
	    		    o.setSpol(spol);
	    		    o.setId(treneri.get(treneri.size()-1).getId()+1);
	    		    
	    		    repo.save(o);
	    		    System.out.println("Prošlo 3");
	    		    return new ResponseEntity("Uspješno kreiran trener!" , HttpStatus.OK);
	    
	    }
	    return new ResponseEntity("Greška!" , HttpStatus.NOT_FOUND);
	   
	  }

	
	
	@RequestMapping(value="/treneri/update/{id}/{spol}/{godine}/{edukacija}/{iskustvo}/{brojKlijenata}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<String> UpdateTrener(@PathVariable Integer id,@PathVariable String spol, @PathVariable Integer godine,@PathVariable String edukacija,@PathVariable Integer iskustvo, @PathVariable Integer brojKlijenata, @PathVariable Integer idOsoba) {
		List<Trener> treneri= (List<Trener>) repo.findAll();
	    List<Osoba> osobe= (List<Osoba>) repoo.findAll();

		RestTemplate rs= new RestTemplate();
		for(Trener o: treneri)
		{
			if(o.getId()==id)
			{
				if(!o.getSpol().equals(spol)) o.setSpol(spol);
				
				if(o.getGodine()!=godine) o.setGodine(godine);
				
				if(!o.getEdukacija().equals(edukacija)) o.setEdukacija(edukacija);
				
				if(o.getIskustvo()!=iskustvo) o.setIskustvo(iskustvo);
				
				if(o.getBrojKlijenata()!=brojKlijenata) o.setBrojKlijenata(brojKlijenata);
				
				for(Osoba nova:osobe)
				{
					if(nova.getId()==idOsoba)
					{
						o.setOsoba(nova);
					}
				}
				
    		    Map<String, String> vars = new HashMap<String, String>();
    		    vars.put("id", id.toString());
				vars.put("spol", spol);
    		    vars.put("godine", godine.toString());
    		    vars.put("edukacija", edukacija);
    		    vars.put("iskustvo", iskustvo.toString());
    		    vars.put("brojKlijenata", brojKlijenata.toString());
    		    vars.put("idOsoba", idOsoba.toString());
    		    repo.save(o);
    			return new ResponseEntity("Uspješno update-ovana osoba sa id-em: " + o.getId(), HttpStatus.OK);
			}
		}
		
	    return new ResponseEntity("Nije pronadjena osoba sa zeljenim id-em!" , HttpStatus.NOT_FOUND);
	  }
	
	
	
}