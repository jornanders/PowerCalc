package no.jascorp.powercalc.domain.regning;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Jørn Anders Svendsen
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "regning_linje")
public class RegningLinje implements Serializable {
	
	private static final long serialVersionUID = 558235322801883129L;

	@Id
	@GeneratedValue(generator = "regninglinje", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "regninglinje", sequenceName = "regning_linje_seq")
	@Column(name = "regningLinjeId", nullable = false)
	private Integer regningLinjeId;

	@JoinColumn(name = "regningId")
	@ManyToOne(fetch = FetchType.LAZY) 
	private Regning regning;

	public Regning getRegning() {
		return regning;
	}

	public void setRegning(Regning regning) {
		this.regning = regning;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "avsender", nullable = false)
	private final Avsender avender;
	
	@Column(name="sumverdi", nullable = false, scale = 5, precision = 2)
	private final double sum;

	RegningLinje() {
		this.avender = null;
		this.sum = 0;
	}

	public RegningLinje(Avsender avsender, double sum) {
		this.avender = avsender;
		this.sum = sum;
	}

	private RegningLinje(Builder builder) {
		this.avender = builder.avender;
		this.sum = builder.sum;
	}

	public Integer getRegningLinjId() {
		return regningLinjeId;
	}

	public Avsender getAvender() {
		return avender;
	}
	
	public double getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "RegningLinje [regningLinjeId:" + regningLinjeId + ", regningId:" + regning.getRegningId() + ", avender:" + avender
				+ ", sum:" + sum + "]";
	}
	
	public static Builder forAvsender(Avsender avsender) {
		return new Builder(avsender);
	}
	
	public static Builder fraLierEverk() {
		return forAvsender(Avsender.LIER_EVERK);
	}
	
	public static Builder fraEB() {
		return forAvsender(Avsender.EB);
	}

	public static Builder fraGlitreStrøm() {
		return forAvsender(Avsender.GLITRE_STRØM);
	}

	public static Builder fraGlitreNett() {
		return forAvsender(Avsender.GLITRE_NETT);
	}

	public static class Builder {
		private final Avsender avender;
		private double sum;

		Builder(Avsender avender) {
			this.avender = avender;
		}
		
		public RegningLinje medSum(double sum) {
			this.sum = sum;
			return build();
		}

		public Builder sum(double sum) {
			this.sum = sum;
			return this;
		}
		
		public RegningLinje build() {
			return new RegningLinje(this);
		}
	}
}
