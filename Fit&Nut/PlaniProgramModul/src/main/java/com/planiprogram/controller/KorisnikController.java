package com.planiprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planiprogram.module.Korisnik;
import com.planiprogram.repository.KorisnikRepository;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {
	@Autowired
	  private KorisnikRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Korisnik> getAll() {
	    return (List<Korisnik>) repo.findAll();
	  }

}
