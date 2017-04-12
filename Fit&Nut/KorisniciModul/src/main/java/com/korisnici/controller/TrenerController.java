package com.korisnici.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.korisnici.module.Trener;
import com.korisnici.repository.TrenerRepository;

@RestController
@RequestMapping("/treneri")
public class TrenerController {
	@Autowired
	  private TrenerRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Trener> getAll() {
	    return (List<Trener>) repo.findAll();
	  }

}