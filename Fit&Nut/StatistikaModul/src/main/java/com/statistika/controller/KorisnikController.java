package com.statistika.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.statistika.module.Korisnik;
import com.statistika.module.Osoba;
import com.statistika.module.Trener;
import com.statistika.repository.KorisnikRepository;
import com.statistika.repository.OsobaRepository;
import com.statistika.repository.TrenerRepository;

@CrossOrigin
@RestController
@RequestMapping("/statistika")
public class KorisnikController {
	@Autowired
	  private KorisnikRepository repo;
	@Autowired
	private OsobaRepository repoo;
	@Autowired
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
	    		RestTemplate rs= new RestTemplate();
	    		//String rez= rs.getForObject("http://localhost:8082/planiprogram/osobe/izbrisi/{id}", String.class, id);
	    		//String rez2= rs.getForObject("http://localhost:8083/statistika/osobe/izbrisi/{id}", String.class, id);
	    		repo.delete(o);
	    		return new ResponseEntity("Uspješno izbrisan korisnik sa id-em: " + id, HttpStatus.OK);
	    	}
	    }
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " + id, HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/korisnik/dodaj/{spol}/{godine}/{visina}/{tezina}/{zeljenaTezina}/{bolesti}/{idTrener}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<String> DodajKorisnika(@PathVariable String spol, @PathVariable Integer godine, @PathVariable Integer visina, 
			  @PathVariable Integer tezina, @PathVariable Integer zeljenaTezina, @PathVariable String bolesti,
			  @PathVariable Integer idTrener, @PathVariable Integer idOsoba) {
		
		List<Korisnik> korisnici= (List<Korisnik>) repo.findAll();
		List<Osoba> osobe= (List<Osoba>) repoo.findAll();
		List<Trener> treneri= (List<Trener>) repot.findAll();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd"); 
		Date datum = new Date();
		try {
			datum = dt.parse(datum.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
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
				novi.setZeljenaKilaza(zeljenaTezina);
				novi.setDatumPristupa(datum);
				novi.setId(korisnici.get(korisnici.size()-1).getId()+1);
				 		repo.save(novi);
				
	    		return new ResponseEntity("Uspješno kreiran korisnik! " , HttpStatus.OK);
			}
		}
		
		
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " , HttpStatus.NOT_FOUND);
	  }
	
	@RequestMapping(value="/korisnik/update/{id}/{spol}/{godine}/{visina}/{tezina}/{zeljenaTezina}/{bolesti}/{idTrener}/{idOsoba}", method=RequestMethod.GET)
	  public ResponseEntity<String> UpdateKorisnika(@PathVariable Integer id, @PathVariable String spol, @PathVariable Integer godine, @PathVariable Integer visina, 
			  @PathVariable Integer tezina, @PathVariable Integer zeljenaTezina, @PathVariable String bolesti,
			  @PathVariable Integer idTrener, @PathVariable Integer idOsoba) {
		
		List<Korisnik> korisnici= (List<Korisnik>) repo.findAll();
		List<Osoba> osobe= (List<Osoba>) repoo.findAll();
		List<Trener> treneri= (List<Trener>) repot.findAll();
		RestTemplate rs= new RestTemplate();
		Map<String, String> vars = new HashMap<String, String>();
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
				if(o.getZeljenaKilaza()!=zeljenaTezina) o.setZeljenaKilaza(zeljenaTezina);
				if(!o.getBolesti().equals(bolesti)) o.setBolesti(bolesti);
				
					repo.save(o);
				
	    		 return new ResponseEntity("Uspješan update! " , HttpStatus.OK);
			}
		}
		
		
	    return new ResponseEntity("Nije pronađen korisnik sa id-em : " , HttpStatus.NOT_FOUND);
	  }
	
}
