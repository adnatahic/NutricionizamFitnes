package com.statistika.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.statistika.module.Osoba;
import com.statistika.repository.OsobaRepository;

@RestController
@RequestMapping("/osobe")
public class OsobaController {
	@Autowired
	  private OsobaRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Osoba> getAll() {
	    return (List<Osoba>) repo.findAll();
	  }

}
