package com.planiprogram.module;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the komentari database table.
 * 
 */
@Embeddable
public class KomentariPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_trener", insertable=false, updatable=false)
	private int idTrener;

	private String tekst;

	@Temporal(TemporalType.DATE)
	private java.util.Date datum;

	@Column(name="id_korisnik", insertable=false, updatable=false)
	private int idKorisnik;

	public KomentariPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTrener() {
		return this.idTrener;
	}
	public void setIdTrener(int idTrener) {
		this.idTrener = idTrener;
	}
	public String getTekst() {
		return this.tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public java.util.Date getDatum() {
		return this.datum;
	}
	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}
	public int getIdKorisnik() {
		return this.idKorisnik;
	}
	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KomentariPK)) {
			return false;
		}
		KomentariPK castOther = (KomentariPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idTrener == castOther.idTrener)
			&& this.tekst.equals(castOther.tekst)
			&& this.datum.equals(castOther.datum)
			&& (this.idKorisnik == castOther.idKorisnik);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idTrener;
		hash = hash * prime + this.tekst.hashCode();
		hash = hash * prime + this.datum.hashCode();
		hash = hash * prime + this.idKorisnik;
		
		return hash;
	}
}