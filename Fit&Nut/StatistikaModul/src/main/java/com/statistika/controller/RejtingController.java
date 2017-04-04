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
import com.statistika.module.Rejting;
import com.statistika.repository.OsobaRepository;
import com.statistika.repository.RejtingRepository;

@RestController
@RequestMapping("/rejting")
public class RejtingController {
	@Autowired
	  private RejtingRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Rejting> getAll() {
	    return (List<Rejting>) repo.findAll();
	  }

}
