package com.planiprogram.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planiprogram.module.Osoba;
import com.planiprogram.repository.OsobaRepository;



import org.json.JSONObject;

@RestController
@RequestMapping("/osobe")
public class OsobaController {
	@Autowired
	  private OsobaRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	
	  public List<Osoba> getAll() {
	    return (List<Osoba>) repo.findAll();
	  }
	
//	private static String readAll(Reader rd) throws IOException {
//	    StringBuilder sb = new StringBuilder();
//	    int cp;
//	    while ((cp = rd.read()) != -1) {
//	      sb.append((char) cp);
//	    }
//	    return sb.toString();
//	  }
//
//	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
//	    InputStream is = new URL(url).openStream();
//	    try {
//	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//	      String jsonText = readAll(rd);
//	      JSONObject json = new JSONObject(jsonText);
//	      return json;
//	    } finally {
//	      is.close();
//	    }
//	  }

//	  @RequestMapping(value="/planiprogram/update/osobe", method=RequestMethod.GET)
//	  public void Vrati()throws IOException, JSONException {
//		  
//		  JSONObject json = readJsonFromUrl("http://localhost:8080/osobe/svi");
//		    System.out.println(json.toString());
//		    System.out.println(json.get("id"));
//		    
//		   // return (List<Osoba>) repo.findAll(); 
//	  }

}
