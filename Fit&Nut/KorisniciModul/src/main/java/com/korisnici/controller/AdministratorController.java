package com.korisnici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.korisnici.module.Administrator;
import com.korisnici.repository.AdministratorRepository;

@RestController
@RequestMapping("/administratori")
public class AdministratorController {
	@Autowired
	  private AdministratorRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Administrator> getAll() {
	    return (List<Administrator>) repo.findAll();
	  }

}
