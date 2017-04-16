package com.planiprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planiprogram.module.Trening;
import com.planiprogram.repository.TreningRepository;

@RestController
@RequestMapping("/planiprogram")
public class TreningController {
	@Autowired
	  private TreningRepository repo;
	
	@RequestMapping(value="/treninzi/svi",method=RequestMethod.GET)
	  public List<Trening> getAll() {
	    return (List<Trening>) repo.findAll();
	  }
	
	
	

}
