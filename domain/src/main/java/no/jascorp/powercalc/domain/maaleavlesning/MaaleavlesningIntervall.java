package no.jascorp.powercalc.domain.maaleavlesning;

import java.util.Date;

import no.jascorp.powercalc.domain.common.Datointervall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jørn Anders Svendsen
 */
class MaaleavlesningIntervall {
	private final Maaleavlesning fraAvlesning;
	private final Maaleavlesning tilAvlesning;
	private final Datointervall avlesningIntervall;
	
	private MaaleavlesningIntervall forrigeIntervall;
	private MaaleavlesningIntervall nesteIntervall;
	
	public static final MaaleavlesningIntervall NULL_INTERVALL;

	private final static Logger logger = LoggerFactory.getLogger(MaaleavlesningIntervall.class);
	
	static {
		NULL_INTERVALL = new MaaleavlesningIntervall(Maaleavlesning.NULL_AVLESNING, Maaleavlesning.NULL_AVLESNING, null);
		NULL_INTERVALL.setForrigeIntervall(NULL_INTERVALL);
		NULL_INTERVALL.setNesteIntervall(NULL_INTERVALL);
	}
	
	MaaleavlesningIntervall(Maaleavlesning fraAvlesning, Maaleavlesning tilAvlesning, MaaleavlesningIntervall forrigeIntervall) {
		this.fraAvlesning = fraAvlesning;
		this.tilAvlesning = tilAvlesning;
		this.avlesningIntervall = new Datointervall(fraAvlesning.getDato(), tilAvlesning.getDato());
		this.forrigeIntervall = forrigeIntervall;
		if (forrigeIntervall != null) {
			this.forrigeIntervall.setNesteIntervall(this);
		}
	}
	
	void setNesteIntervall(MaaleavlesningIntervall neste) {
		this.nesteIntervall = neste;
	}
	
	void setForrigeIntervall(MaaleavlesningIntervall forrige) {
		this.forrigeIntervall = forrige;
	}

	Datointervall getAvlesningDatointervall() {
		return avlesningIntervall;
	}

	double getForbruk() {
		logger.debug("getForbruk: {}", fraAvlesning.getForbruk(tilAvlesning));
		return fraAvlesning.getForbruk(tilAvlesning);
	}
	
	double getForbruk(Datointervall intervalToCalculate) {
		boolean intervalToCalcCompletedBeforeOrAfterAvlesninger = isTilDatoForDatointervallBeforeForsteAvlesning(intervalToCalculate) || isFraDatoForDatointervallAfterSisteAvlesning(intervalToCalculate); 
		
		Date fraDato = intervalToCalcCompletedBeforeOrAfterAvlesninger 
			|| isFraDatoIntervallBeforeMaalingAndIsFirst(intervalToCalculate) 
			|| getAvlesningDatointervall().isDateInRange(intervalToCalculate.getFraDato()) ? intervalToCalculate.getFraDato() : getAvlesningDatointervall().getFraDato();
		
		Date tilDato = intervalToCalcCompletedBeforeOrAfterAvlesninger 
			|| isTilDatoIntervallAfterMaalingAndIsLast(intervalToCalculate)
			|| getAvlesningDatointervall().isDateInRange(intervalToCalculate.getTilDato()) ? intervalToCalculate.getTilDato() : getAvlesningDatointervall().getTilDato();
		intervalToCalculate = new Datointervall(fraDato, tilDato);
		double forbruk = ((double)fraAvlesning.getForbruk(tilAvlesning) / avlesningIntervall.getAntallDagerForIntervall()) * (intervalToCalculate.getAntallDagerForIntervall());
		logger.debug("getForbruk: " + fraAvlesning.getForbruk(tilAvlesning) + " / " + avlesningIntervall.getAntallDagerForIntervall() + " * " + intervalToCalculate + " : kWh " + forbruk);
		return forbruk;
	}
	
	
	private boolean isFraDatoForDatointervallAfterSisteAvlesning(Datointervall datointervall) {
		return datointervall.getFraDato().after(avlesningIntervall.getTilDato()) && nesteIntervall == null;
	}

	private boolean isTilDatoForDatointervallBeforeForsteAvlesning(Datointervall datointervall) {
		return datointervall.getTilDato().before(avlesningIntervall.getFraDato()) && forrigeIntervall == null;
	}
	
	private boolean isFraDatoIntervallBeforeMaalingAndIsFirst(Datointervall datointervall) {
		return avlesningIntervall.isFraDatoBefore(datointervall) && forrigeIntervall == null;
	}

	private boolean isTilDatoIntervallAfterMaalingAndIsLast(Datointervall datointervall) {
		return avlesningIntervall.isTilDatoAfter(datointervall) && nesteIntervall == null;
	}

	@Override
	public String toString() {
		return "Intervall: " + avlesningIntervall 
			+ "\nfraAvlesning: " + fraAvlesning
			+ "\ntilAvlesning: " + tilAvlesning
			+ "\nforbruk: " + getForbruk();
	}
	
	MaaleavlesningIntervall getForrigeIntervall() {
		return forrigeIntervall;
	}

	MaaleavlesningIntervall getNesteIntervall() {
		return nesteIntervall;
	}

	MaaleavlesningIntervall getForsteIntervall() {
		MaaleavlesningIntervall intervall = this;
		while (intervall.getForrigeIntervall() != null && intervall != NULL_INTERVALL) {
			intervall = intervall.getForrigeIntervall();
		}
		return intervall;
	}
	
	MaaleavlesningIntervall getSisteIntervall() {
		MaaleavlesningIntervall intervall = this;
		while (intervall.getNesteIntervall() != null && intervall != NULL_INTERVALL) {
			intervall = intervall.getNesteIntervall();
		}
		return intervall;
	}
}
