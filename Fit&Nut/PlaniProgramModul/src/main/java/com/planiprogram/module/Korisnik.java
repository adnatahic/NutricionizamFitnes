package com.planiprogram.module;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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

	private Integer tezina;

	private Integer visina;

	@Column(name="zeljena_tezina")
	private Integer zeljenaTezina;

	
	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="id_osoba")
	private Osoba osoba;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="id_trener")
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

	public Integer getTezina() {
		return this.tezina;
	}

	public void setTezina(Integer tezina) {
		this.tezina = tezina;
	}

	public Integer getVisina() {
		return this.visina;
	}

	public void setVisina(Integer visina) {
		this.visina = visina;
	}

	public Integer getZeljenaTezina() {
		return this.zeljenaTezina;
	}

	public void setZeljenaTezina(Integer zeljenaTezina) {
		this.zeljenaTezina = zeljenaTezina;
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