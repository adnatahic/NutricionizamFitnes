package com.module;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the parametritreninga database table.
 * 
 */
@Entity
@NamedQuery(name="Parametritreninga.findAll", query="SELECT p FROM Parametritreninga p")
public class Parametritreninga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private BigDecimal tezina;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="id_korisnika")
	private Korisnik korisnik;

	public Parametritreninga() {
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

	public BigDecimal getTezina() {
		return this.tezina;
	}

	public void setTezina(BigDecimal tezina) {
		this.tezina = tezina;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}