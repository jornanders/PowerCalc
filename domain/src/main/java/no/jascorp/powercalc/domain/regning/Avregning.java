package no.jascorp.powercalc.domain.regning;

import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;

import org.apache.log4j.Logger;

/**
 * @author Jørn Anders Svendsen
 */
public class Avregning {
	private final Regning regning;
	private Maaleavlesninger avlesninger;

	public Avregning(Regning regning, Maaleavlesninger avlesninger) {
		this.regning = regning;
		this.avlesninger = avlesninger;
	}

	public double beregnProsentandel(Maalepunkt maalepunkt) {
		double prosentandel = maalepunkt.beregnProsentandel(avlesninger, regning.getIntervall());
		Logger.getLogger(getClass()).debug("Prosentandel " + maalepunkt + ": " + prosentandel);
		return prosentandel;
	}
	
	public double beregnSum(Maalepunkt maalepunkt) {
		double sum = regning.getSum() * beregnProsentandel(maalepunkt);
		Logger.getLogger(getClass()).debug("Sum " + maalepunkt + " " + regning.getIntervall() + ": NOK " + sum);
		return sum;
	}

	public double beregnForbruk(Maalepunkt maalepunkt) {
		double forbruk = maalepunkt.beregnForbruk(avlesninger, regning.getIntervall());
		Logger.getLogger(getClass()).debug("Forbruk " + maalepunkt + ": kWh " + forbruk);
		return forbruk;
	}
}
