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
	private int id;

	private int brojKlijenata;

	private String edukacija;

	private int godine;

	@Column(name="id_osoba")
	private int idOsoba;

	private int iskustvo;

	private String spol;

	//bi-directional many-to-one association to Korisnik
	@OneToMany(mappedBy="trener")
	private List<Korisnik> korisniks;

	public Trener() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrojKlijenata() {
		return this.brojKlijenata;
	}

	public void setBrojKlijenata(int brojKlijenata) {
		this.brojKlijenata = brojKlijenata;
	}

	public String getEdukacija() {
		return this.edukacija;
	}

	public void setEdukacija(String edukacija) {
		this.edukacija = edukacija;
	}

	public int getGodine() {
		return this.godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public int getIdOsoba() {
		return this.idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public int getIskustvo() {
		return this.iskustvo;
	}

	public void setIskustvo(int iskustvo) {
		this.iskustvo = iskustvo;
	}

	public String getSpol() {
		return this.spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Korisnik addKorisnik(Korisnik korisnik) {
		getKorisniks().add(korisnik);
		korisnik.setTrener(this);

		return korisnik;
	}

	public Korisnik removeKorisnik(Korisnik korisnik) {
		getKorisniks().remove(korisnik);
		korisnik.setTrener(null);

		return korisnik;
	}

}