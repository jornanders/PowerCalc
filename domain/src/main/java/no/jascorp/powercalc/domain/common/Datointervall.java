/**
 * 
 */
package no.jascorp.powercalc.domain.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import no.jascorp.powercalc.util.Utils;

/**
 * @author Jørn Anders Svendsen
 */
@Embeddable
public class Datointervall {

	@Temporal(TemporalType.DATE)
	@Column(name = "fradato", nullable = false, length = 10)
	private final Date fraDato;

	@Temporal(TemporalType.DATE)
	@Column(name = "tildato", nullable = false, length = 10)
	private final Date tilDato;
	
	Datointervall() {
		this.fraDato = null;
		this.tilDato = null;
	}

	public Datointervall(Date fraDato, Date tilDato) {
		if (fraDato == null || tilDato == null) {
			throw new IllegalArgumentException("Dato kan ikke være null");
		}
		if (!tilDato.equals(fraDato) && tilDato.before(fraDato)) {
			throw new IllegalArgumentException("Fra-dato må være før til-dato");
		}
		this.fraDato = new Date(fraDato.getTime());
		this.tilDato = new Date(tilDato.getTime());
	}

	public Datointervall(String fraDato, String tilDato) {
		this(Utils.stringToDate(fraDato), Utils.stringToDate(tilDato));
	}

	public int getAntallDagerForIntervall() {
		if (tilDato.equals(fraDato)) {
			return 0;
		}
		return (int)Math.round((((double)tilDato.getTime() - fraDato.getTime()) / (24 * 3600 * 1000)));
	}

	public Date getFraDato() {
		return new Date(fraDato.getTime());
	}

	public Date getTilDato() {
		return new Date(tilDato.getTime());
	}
	
	public boolean isDateInRange(Date date) {
		return (fraDato.before(date) || fraDato.equals(date)) 
			&& (tilDato.after(date) || tilDato.equals(date));
	}
	
	public boolean isFraDatoBefore(Datointervall toCheck) {
		return toCheck.getFraDato().before(getFraDato());
	}

	public boolean isTilDatoAfter(Datointervall toCheck) {
		return toCheck.getTilDato().after(getTilDato());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fraDato.hashCode();
		result = prime * result + tilDato.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		Datointervall other = (Datointervall) obj;
		if (!fraDato.equals(other.fraDato)) {
			return false;
		}
		
		if (!tilDato.equals(other.tilDato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [#" + getAntallDagerForIntervall() + "] (" + Utils.dateToString(fraDato) + " - " + Utils.dateToString(tilDato) + ")";
	}
}
