package com.planiprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planiprogram.module.Ishrana;
import com.planiprogram.module.Komentari;
import com.planiprogram.repository.IshranaRepository;
import com.planiprogram.repository.KomentariRepository;

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
