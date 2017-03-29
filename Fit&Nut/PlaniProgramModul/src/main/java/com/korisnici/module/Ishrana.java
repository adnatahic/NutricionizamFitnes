package com.korisnici.module;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ishrana database table.
 * 
 */
@Entity
@NamedQuery(name="Ishrana.findAll", query="SELECT i FROM Ishrana i")
public class Ishrana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String dorucak;

	private String rucak;

	private String uzina1;

	private String uzina2;

	private String vecera;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="id_korisnik")
	private Korisnik korisnik;

	public Ishrana() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDorucak() {
		return this.dorucak;
	}

	public void setDorucak(String dorucak) {
		this.dorucak = dorucak;
	}

	public String getRucak() {
		return this.rucak;
	}

	public void setRucak(String rucak) {
		this.rucak = rucak;
	}

	public String getUzina1() {
		return this.uzina1;
	}

	public void setUzina1(String uzina1) {
		this.uzina1 = uzina1;
	}

	public String getUzina2() {
		return this.uzina2;
	}

	public void setUzina2(String uzina2) {
		this.uzina2 = uzina2;
	}

	public String getVecera() {
		return this.vecera;
	}

	public void setVecera(String vecera) {
		this.vecera = vecera;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}