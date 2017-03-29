package com.korisnici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.korisnici.module.Ishrana;
import com.korisnici.module.Komentari;
import com.korisnici.repository.IshranaRepository;
import com.korisnici.repository.KomentariRepository;

@RestController
@RequestMapping("/komentari")
public class KomentariController {
	@Autowired
	  private KomentariRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Komentari> getAll() {
	    return (List<Komentari>) repo.findAll();
	  }

}
