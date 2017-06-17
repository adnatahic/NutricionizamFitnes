package com.korisnici.module;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trener database table.
 * 
 */
@Entity
@NamedQuery(name="Trener.findAll", query="SELECT t FROM Trener t")
public class Trener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer brojKlijenata;

	private String edukacija;

	private Integer godine;

	private Integer iskustvo;

	private String spol;

	
	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="idOsoba")
	private Osoba osoba;

	public Trener() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrojKlijenata() {
		return this.brojKlijenata;
	}

	public void setBrojKlijenata(Integer brojKlijenata) {
		this.brojKlijenata = brojKlijenata;
	}

	public String getEdukacija() {
		return this.edukacija;
	}

	public void setEdukacija(String edukacija) {
		this.edukacija = edukacija;
	}

	public Integer getGodine() {
		return this.godine;
	}

	public void setGodine(Integer godine) {
		this.godine = godine;
	}

	public Integer getIskustvo() {
		return this.iskustvo;
	}

	public void setIskustvo(Integer iskustvo) {
		this.iskustvo = iskustvo;
	}

	public String getSpol() {
		return this.spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}