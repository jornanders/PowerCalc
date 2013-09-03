package no.jascorp.powercalc.domain.regning;

import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class Avregning {
	private final Regning regning;
	private Maaleavlesninger avlesninger;

	private final static Logger logger = LoggerFactory.getLogger(Avregning.class);
	
	public Avregning(Regning regning, Maaleavlesninger avlesninger) {
		this.regning = regning;
		this.avlesninger = avlesninger;
	}
	
	public Regning getRegning() {
		return regning;
	}

	public double beregnProsentandel(Maalepunkt maalepunkt) {
		double prosentandel = maalepunkt.beregnProsentandel(avlesninger, regning.getIntervall());
		logger.debug("Prosentandel " + maalepunkt + ": " + prosentandel);
		return prosentandel;
	}
	
	public double beregnSum(Maalepunkt maalepunkt) {
		double sum = regning.getSum() * beregnProsentandel(maalepunkt);
		logger.debug("Sum " + maalepunkt + " " + regning.getIntervall() + ": NOK " + sum);
		return sum;
	}

	public double beregnForbruk(Maalepunkt maalepunkt) {
		double forbruk = maalepunkt.beregnForbruk(avlesninger, regning.getIntervall());
		logger.debug("Forbruk " + maalepunkt + ": kWh " + forbruk);
		return forbruk;
	}
}
