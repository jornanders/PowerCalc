package no.jascorp.powercalc.domain.regning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import no.jascorp.powercalc.domain.common.Datointervall;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.util.Utils;

/**
 * @author Jørn Anders Svendsen
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "regning")
public class Regning {
	
	@Id
	@GeneratedValue(generator = "regning", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "regning", sequenceName = "regning_seq")
	@Column(name = "regningId", nullable = false)
	private Integer regningId;
	
	private final Datointervall intervall;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "regning")
	@Column(name="regningId")
	private final Set<RegningLinje> linjer = new HashSet<RegningLinje>(0) ;

	public Regning(Datointervall intervall) {
		this.intervall = intervall;
	}
	
	public Regning(String fra, String til) {
		this(new Datointervall(Utils.stringToDate(fra), Utils.stringToDate(til)));
	}
	
	Regning() {
		this.regningId = 0;
		this.intervall = null;
	}

	public Regning(Builder builder) {
		this(builder.fraDato, builder.tilDato);
		this.linjer.addAll(builder.linjer);
	}

	public Integer getRegningId() {
		return regningId;
	}

	public void addRegningLinje(RegningLinje linje) {
		linje.setRegning(this);
		linjer.add(linje);
	}

	public Datointervall getIntervall() {
		return intervall;
	}

	public double getSum() {
		double sum = 0;
		for (RegningLinje linje : linjer) {
			sum += linje.getSum();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\nRegning [regningId:" + regningId + ", intervall:" + intervall + ", sum:" + getSum() + " linjer: \n");
		for(RegningLinje linje : linjer) {
			sb.append("\t").append(linje).append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static Builder fra(String fraDato) {
		return new Builder(fraDato); 
	}
	
	public static class Builder {
		private final String fraDato;
		private String tilDato;
		
		private List<RegningLinje> linjer = new ArrayList<>();

		public Builder(String fraDato) {
			this.fraDato = fraDato;
		}

		public Builder til(String tilDato) {
			this.tilDato = tilDato;
			return this;
		}
		
		public Builder linje(RegningLinje linje) {
			linjer.add(linje);
			return this;
		}
		
		public Avregning medAvlesninger(Maaleavlesninger avlesninger) {
			Regning regning = build();
			return new Avregning(regning, avlesninger);
		}
		
		public Regning build() {
			return new Regning(this);
		}
	}
}
