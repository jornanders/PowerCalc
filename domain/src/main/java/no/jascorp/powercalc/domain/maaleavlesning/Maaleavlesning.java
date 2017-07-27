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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.google.common.base.Preconditions;
import no.jascorp.powercalc.util.Utils;

import org.hibernate.annotations.Immutable;

/**
 * @author Jørn Anders Svendsen
 *
 */
@Entity
@Immutable
@Access(AccessType.FIELD)
@Table(name = "maaleavlesning")
public class Maaleavlesning implements Comparable<Maaleavlesning>, Serializable {
	
	private static final long serialVersionUID = -7620353780592322335L;

	public static final Maaleavlesning NULL_AVLESNING = new Maaleavlesning(Maalepunkt.NULL_VALUE, Utils.stringToDate("01.01.1900"), 0, 0);
	
	@Id
	@GeneratedValue(generator = "maaleavlesning", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "maaleavlesning", sequenceName = "maaleavlesning_seq")
	@Column(name = "avlesningId", nullable = false)
	private Integer avlesningId;

	@Enumerated(EnumType.STRING)
	@Column(name = "punkt", nullable = false)
	@NotNull
	private final Maalepunkt punkt;

	@Temporal(TemporalType.DATE)
	@Column(name = "dato", nullable = false, length = 10)
	@NotNull
	@Past
	private final Date dato;
	
	@Column(name = "stand", nullable = false)
	@Min(1)
	private final int stand;

	@Column(name = "forbruk", nullable = true)
	@Min(0)
	private final int forbruk;

	Maaleavlesning() {
		this.punkt = null;
		this.dato = null;
		this.stand = 0;
		this.forbruk= 0;
	}

	public Maaleavlesning(Maalepunkt punkt, Date dato, int stand, int forbruk) {
		Utils.assertNotNull(punkt, "Målepunkt kan ikke være null");
		this.punkt = punkt;
		this.dato = new Date(dato.getTime());
		this.stand = stand;
		this.forbruk = forbruk;
	}
	
	public Integer getAvlesningId() {
		return this.avlesningId;
	}
	
	public void setAvlesningId(Integer avlesningId) {
		this.avlesningId = avlesningId;
	}

	public Maaleavlesning(Maalepunkt punkt, String dato, int stand, int forbruk) {
		this(punkt, Utils.stringToDate(dato), stand, forbruk);
	}

	public Maaleavlesning(Builder builder) {
		this(builder.maalepunkt, builder.dato, builder.stand, builder.forbruk);
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
			throw new IllegalArgumentException("Måling for " + this.getDato() + ", " + this.getPunkt() + " er allerede registrert");
		}
		return o.getDato().before(this.getDato()) ? 1 : -1;
	}
	
	public int beregnForbruk(Maaleavlesning tilAvlesning) {
		return tilAvlesning.getStand() - getStand();
	}

	public int getForbruk() {
		return forbruk;
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
	
	public static Builder forPunkt(Maalepunkt punkt) {
		return new Builder(punkt);
	}
	
	public static Builder forHybel() {
		return forPunkt(Maalepunkt.HYBELMAALER);
	}

	public static Builder forHoved() {
		return forPunkt(Maalepunkt.HOVEDMAALER);
	}

	public static Builder from(Maaleavlesning maaleavlesning) {
		Builder builder = forPunkt(maaleavlesning.punkt);
		builder.dato = Utils.dateToString(maaleavlesning.dato);
		builder.stand = maaleavlesning.stand;
		builder.forbruk = maaleavlesning.forbruk;
		return builder;
	}

	public static class Builder {
		private final Maalepunkt maalepunkt;
		private String dato;
		private int stand;
		private int forbruk;

		public Builder(Maalepunkt maalepunkt) {
			this.maalepunkt = maalepunkt;
		}
		
		public Builder dato(String dato) {
			this.dato = dato;
			return this;
		}

		public Builder stand(int stand) {
			this.stand = stand;
			return this;
		}

		public Builder forbruk(int forbruk) {
			this.forbruk = forbruk;
			return this;
		}

		public Maaleavlesning build() {
			return new Maaleavlesning(this);
		}
	}
}