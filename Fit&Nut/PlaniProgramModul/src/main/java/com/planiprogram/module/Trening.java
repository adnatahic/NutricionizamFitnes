package com.planiprogram.module;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trening database table.
 * 
 */
@Entity
@NamedQuery(name="Trening.findAll", query="SELECT t FROM Trening t")
public class Trening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String opis;

	private int trajanje;

	private String vrsta;	

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="id_korisnik")
	private Korisnik korisnik;

	public Trening() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getVrsta() {
		return this.vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}