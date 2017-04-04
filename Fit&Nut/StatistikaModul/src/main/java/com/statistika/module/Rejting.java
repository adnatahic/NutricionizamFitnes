package com.statistika.module;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rejting database table.
 * 
 */
@Entity
@NamedQuery(name="Rejting.findAll", query="SELECT r FROM Rejting r")
public class Rejting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ocjena;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="id_korisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="id_trener")
	private Trener trener;

	public Rejting() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOcjena() {
		return this.ocjena;
	}

	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
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