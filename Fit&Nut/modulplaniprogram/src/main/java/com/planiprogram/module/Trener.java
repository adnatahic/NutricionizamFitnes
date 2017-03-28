package com.planiprogram.module;

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

	@Column(name="broj_klijenata")
	private int brojKlijenata;

	private String edukacija;

	private int godine;

	private int iskustvo;

	private String spol;

	//bi-directional many-to-one association to Komentari
	@OneToMany(mappedBy="trener")
	private List<Komentari> komentaris;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="id_osoba")
	private Osoba osoba;

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

	public List<Komentari> getKomentaris() {
		return this.komentaris;
	}

	public void setKomentaris(List<Komentari> komentaris) {
		this.komentaris = komentaris;
	}

	public Komentari addKomentari(Komentari komentari) {
		getKomentaris().add(komentari);
		komentari.setTrener(this);

		return komentari;
	}

	public Komentari removeKomentari(Komentari komentari) {
		getKomentaris().remove(komentari);
		komentari.setTrener(null);

		return komentari;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}