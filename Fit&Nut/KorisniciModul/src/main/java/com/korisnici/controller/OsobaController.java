package com.korisnici.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korisnici.module.Osoba;
import com.korisnici.repository.OsobaRepository;

@RestController
public class OsobaController {
	@Autowired
	  private OsobaRepository repo;
	
	@RequestMapping(value="/osobe/svi", method=RequestMethod.GET)
	  public List<Osoba> getAll() {
	    return (List<Osoba>) repo.findAll();
	  }
	
	 @RequestMapping(value= "/osobe", method=RequestMethod.GET)
	    public Osoba vratiosobe(@RequestParam (value="id", defaultValue="1") Integer id) {
	        return ((List<Osoba>) repo.findAll()).get(id-1);
	    }
}
