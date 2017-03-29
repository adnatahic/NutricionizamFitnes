package com.korisnici.module;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the komentari database table.
 * 
 */
@Entity
@NamedQuery(name="Komentari.findAll", query="SELECT k FROM Komentari k")
public class Komentari implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String tekst;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="id_korisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="id_trener")
	private Trener trener;

	public Komentari() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Trener getTrener() {
		return this.trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

}