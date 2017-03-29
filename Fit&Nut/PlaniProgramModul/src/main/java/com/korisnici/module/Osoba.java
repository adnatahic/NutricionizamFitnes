package com.korisnici.module;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Korisnik
	@OneToMany(mappedBy="osoba")
	private List<Korisnik> korisniks;

	//bi-directional many-to-one association to Trener
	@OneToMany(mappedBy="osoba")
	private List<Trener> treners;

	public Osoba() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Korisnik addKorisnik(Korisnik korisnik) {
		getKorisniks().add(korisnik);
		korisnik.setOsoba(this);

		return korisnik;
	}

	public Korisnik removeKorisnik(Korisnik korisnik) {
		getKorisniks().remove(korisnik);
		korisnik.setOsoba(null);

		return korisnik;
	}

	public List<Trener> getTreners() {
		return this.treners;
	}

	public void setTreners(List<Trener> treners) {
		this.treners = treners;
	}

	public Trener addTrener(Trener trener) {
		getTreners().add(trener);
		trener.setOsoba(this);

		return trener;
	}

	public Trener removeTrener(Trener trener) {
		getTreners().remove(trener);
		trener.setOsoba(null);

		return trener;
	}

}