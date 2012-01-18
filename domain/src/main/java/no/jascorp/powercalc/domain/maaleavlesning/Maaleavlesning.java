package no.jascorp.powercalc.domain.maaleavlesning;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import no.jascorp.powercalc.util.Utils;

import org.hibernate.annotations.Immutable;

/**
 * @author J�rn Anders Svendsen
 */
@Entity()
@Immutable
@Access(AccessType.FIELD)
@Table(name = "maaleavlesning")
public class Maaleavlesning implements Comparable<Maaleavlesning>, Serializable {
	
	private static final long serialVersionUID = -7620353780592322335L;

	public static final Maaleavlesning NULL_AVLESNING = new Maaleavlesning(Maalepunkt.NULL_VALUE, Utils.stringToDate("01.01.1900"), 0); 
	
	@Id
	@GeneratedValue
	@Column(name = "avlesningId", nullable = false)
	private Integer avlesningId;

	@Enumerated(EnumType.STRING)
	@Column(name = "punkt", nullable = false)
	private final Maalepunkt punkt;

	@Temporal(TemporalType.DATE)
	@Column(name = "dato", nullable = false, length = 10)
	private final Date dato;
	
	@Column(name = "stand", nullable = false)
	private final int stand;

	Maaleavlesning() {
		this.punkt = null;
		this.dato = null;
		this.stand = 0;
	}

	public Maaleavlesning(Maalepunkt punkt, Date dato, int stand) {
		Utils.assertNotNull(punkt, "M�lepunkt kan ikke v�re null");
		this.punkt = punkt;
		this.dato = new Date(dato.getTime());
		this.stand = stand;
	}
	
	public Integer getAvlesningId() {
		return this.avlesningId;
	}
	
	public void setAvlesningId(Integer avlesningId) {
		this.avlesningId = avlesningId;
	}

	public Maaleavlesning(Maalepunkt punkt, String dato, int stand) {
		this(punkt, Utils.stringToDate(dato), stand);
	}

	public Maalepunkt getPunkt() {
		return punkt;
	}

	public Date getDato() {
		return dato != null 
			? new Date(dato.getTime()) 
			: null;
	}

	public int getStand() {
		return stand;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Punkt: ").append(punkt);
		sb.append(" Dato: " ).append(Utils.dateToString(dato));
		sb.append(" Stand: ").append(stand);
		return sb.toString();
	}

	@Override
	public int compareTo(Maaleavlesning o) {
		if (o.getDato().equals(this.getDato())) {
			throw new IllegalArgumentException("M�ling for " + this.getDato() + ", " + this.getPunkt() + " er allerede registrert");
		}
		return o.getDato().before(this.getDato()) ? 1 : -1;
	}
	
	public int getForbruk(Maaleavlesning tilAvlesning) {
		return tilAvlesning.getStand() - getStand();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dato.hashCode();
		result = prime * result + punkt.hashCode();
		result = prime * result + stand;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maaleavlesning other = (Maaleavlesning) obj;
		if (!dato.equals(other.dato))
			return false;
		if (punkt != other.punkt)
			return false;
		if (stand != other.stand)
			return false;
		return true;
	}
}