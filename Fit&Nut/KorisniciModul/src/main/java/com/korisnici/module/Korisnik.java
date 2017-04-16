package com.korisnici.module;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String bolesti;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_pristupa")
	private Date datumPristupa;

	private int godine;

	private String spol;

	private int tezina;

	private int visina;

	@Column(name="zeljena_kilaza")
	private int zeljenaKilaza;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="idOsoba")
	private Osoba osoba;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="idTrener")
	private Trener trener;

	public Korisnik() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBolesti() {
		return this.bolesti;
	}

	public void setBolesti(String bolesti) {
		this.bolesti = bolesti;
	}

	public Date getDatumPristupa() {
		return this.datumPristupa;
	}

	public void setDatumPristupa(Date datumPristupa) {
		this.datumPristupa = datumPristupa;
	}

	public int getGodine() {
		return this.godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public String getSpol() {
		return this.spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public int getTezina() {
		return this.tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public int getVisina() {
		return this.visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int getZeljenaKilaza() {
		return this.zeljenaKilaza;
	}

	public void setZeljenaKilaza(int zeljenaKilaza) {
		this.zeljenaKilaza = zeljenaKilaza;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public Trener getTrener() {
		return this.trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

}