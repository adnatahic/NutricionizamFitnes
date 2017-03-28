package com.planiprogram.module;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentari database table.
 * 
 */
@Entity
@NamedQuery(name="Komentari.findAll", query="SELECT k FROM Komentari k")
public class Komentari implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KomentariPK id;

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

	public KomentariPK getId() {
		return this.id;
	}

	public void setId(KomentariPK id) {
		this.id = id;
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