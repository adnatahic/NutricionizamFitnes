package com.korisnici.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.korisnici.module.Parametritreninga;
import com.korisnici.repository.ParametritreningaRepository;

@RestController
@RequestMapping("/parametri")
public class ParametritreningaController {
	@Autowired
	  private ParametritreningaRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Parametritreninga> getAll() {
	    return (List<Parametritreninga>) repo.findAll();
	  }

}
