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

	@Column(name="id_trener")
	private int idTrener;

	private String spol;

	private BigDecimal tezina;

	private BigDecimal visina;

	@Column(name="zeljena_tezina")
	private BigDecimal zeljenaTezina;

	//bi-directional many-to-one association to Ishrana
	@OneToMany(mappedBy="korisnik")
	private List<Ishrana> ishranas;

	//bi-directional many-to-one association to Komentari
	@OneToMany(mappedBy="korisnik")
	private List<Komentari> komentaris;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="id_osoba")
	private Osoba osoba;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="korisnik")
	private List<Trening> trenings;

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

	public int getIdTrener() {
		return this.idTrener;
	}

	public void setIdTrener(int idTrener) {
		this.idTrener = idTrener;
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

	public BigDecimal getZeljenaTezina() {
		return this.zeljenaTezina;
	}

	public void setZeljenaTezina(BigDecimal zeljenaTezina) {
		this.zeljenaTezina = zeljenaTezina;
	}

	public List<Ishrana> getIshranas() {
		return this.ishranas;
	}

	public void setIshranas(List<Ishrana> ishranas) {
		this.ishranas = ishranas;
	}

	public Ishrana addIshrana(Ishrana ishrana) {
		getIshranas().add(ishrana);
		ishrana.setKorisnik(this);

		return ishrana;
	}

	public Ishrana removeIshrana(Ishrana ishrana) {
		getIshranas().remove(ishrana);
		ishrana.setKorisnik(null);

		return ishrana;
	}

	public List<Komentari> getKomentaris() {
		return this.komentaris;
	}

	public void setKomentaris(List<Komentari> komentaris) {
		this.komentaris = komentaris;
	}

	public Komentari addKomentari(Komentari komentari) {
		getKomentaris().add(komentari);
		komentari.setKorisnik(this);

		return komentari;
	}

	public Komentari removeKomentari(Komentari komentari) {
		getKomentaris().remove(komentari);
		komentari.setKorisnik(null);

		return komentari;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setKorisnik(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setKorisnik(null);

		return trening;
	}

}