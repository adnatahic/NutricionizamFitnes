package com.korisnici.module;

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

	private BigDecimal tezina;

	private BigDecimal visina;

	@Column(name="zeljena_kilaza")
	private BigDecimal zeljenaKilaza;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="id_osoba")
	private Osoba osoba;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="id_trener")
	private Trener trener;

	//bi-directional many-to-one association to Parametritreninga
	@OneToMany(mappedBy="korisnik")
	private List<Parametritreninga> parametritreningas;

	//bi-directional many-to-one association to Rejting
	@OneToMany(mappedBy="korisnik")
	private List<Rejting> rejtings;

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

	public BigDecimal getTezina() {
		return this.tezina;
	}

	public void setTezina(BigDecimal tezina) {
		this.tezina = tezina;
	}

	public BigDecimal getVisina() {
		return this.visina;
	}

	public void setVisina(BigDecimal visina) {
		this.visina = visina;
	}

	public BigDecimal getZeljenaKilaza() {
		return this.zeljenaKilaza;
	}

	public void setZeljenaKilaza(BigDecimal zeljenaKilaza) {
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

	public List<Parametritreninga> getParametritreningas() {
		return this.parametritreningas;
	}

	public void setParametritreningas(List<Parametritreninga> parametritreningas) {
		this.parametritreningas = parametritreningas;
	}

	public Parametritreninga addParametritreninga(Parametritreninga parametritreninga) {
		getParametritreningas().add(parametritreninga);
		parametritreninga.setKorisnik(this);

		return parametritreninga;
	}

	public Parametritreninga removeParametritreninga(Parametritreninga parametritreninga) {
		getParametritreningas().remove(parametritreninga);
		parametritreninga.setKorisnik(null);

		return parametritreninga;
	}

	public List<Rejting> getRejtings() {
		return this.rejtings;
	}

	public void setRejtings(List<Rejting> rejtings) {
		this.rejtings = rejtings;
	}

	public Rejting addRejting(Rejting rejting) {
		getRejtings().add(rejting);
		rejting.setKorisnik(this);

		return rejting;
	}

	public Rejting removeRejting(Rejting rejting) {
		getRejtings().remove(rejting);
		rejting.setKorisnik(null);

		return rejting;
	}

}