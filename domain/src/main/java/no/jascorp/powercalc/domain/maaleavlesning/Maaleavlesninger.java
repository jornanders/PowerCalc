package no.jascorp.powercalc.domain.maaleavlesning;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import no.jascorp.powercalc.domain.common.Datointervall;

import org.apache.log4j.Logger;

/**
 * @author Jørn Anders Svendsen
 */
public class Maaleavlesninger {
	private HashMap<Maalepunkt, LinkedList<Maaleavlesning>> maaleavlesninger = new HashMap<Maalepunkt, LinkedList<Maaleavlesning>>();
	
	public Maaleavlesninger() {
	}

	public Maaleavlesninger(List<Maaleavlesning> maaleavlesninger) {
		for (Maaleavlesning avlesning : maaleavlesninger) {
			addMaaleavlesning(avlesning);
		}
	}

	public void addMaaleavlesning(Maaleavlesning maaleavlesning) {
		if (maaleavlesning == null) {
			throw new IllegalArgumentException("Måleavlesning kan ikke være null");
		}
		
		LinkedList<Maaleavlesning> avlesninger = getAvlesningerForMaalepunkt(maaleavlesning.getPunkt());
		avlesninger.add(maaleavlesning);
		Collections.sort(avlesninger);
		assureStandIsIncreasing(avlesninger);
	}
	
	private LinkedList<Maaleavlesning> getAvlesningerForMaalepunkt(Maalepunkt maalepunkt) {
		if (!maaleavlesninger.containsKey(maalepunkt)) {
			maaleavlesninger.put(maalepunkt, new LinkedList<Maaleavlesning>());
		}
		return maaleavlesninger.get(maalepunkt);
	}

	private void assureStandIsIncreasing(LinkedList<Maaleavlesning> avlesninger) {
		Maaleavlesning forrige = null;
		for (Maaleavlesning avlesning : avlesninger) {
			if (forrige != null) {
				if (forrige.getStand() > avlesning.getStand()) {
					throw new IllegalArgumentException("Stand som er lagt til er lavere enn forrige stand");
				}
			}
			forrige = avlesning;
		}
	}
	
	public double beregnForbrukForIntervall(final Datointervall datointervall, final Maalepunkt maalepunkt) {
		MaaleavlesningIntervall intervaller = getIntervaller(datointervall, maalepunkt);
		double forbruk = 0;
		while (intervaller != null && intervaller != MaaleavlesningIntervall.NULL_INTERVALL) {
			forbruk += intervaller.getForbruk(datointervall);
			intervaller = intervaller.getNesteIntervall();
		}
		Logger.getLogger(getClass()).debug("Totalt forbruk for, " + maalepunkt + ", intervall (" + datointervall + ") : " + forbruk);
		return forbruk;
	}
	
	public MaaleavlesningIntervall getIntervaller(Maalepunkt maalepunkt) {
		Maaleavlesning forrige = null;
		MaaleavlesningIntervall forrigeIntervall = null;
		for (Maaleavlesning avlesning : getAvlesningerForMaalepunkt(maalepunkt)) {
			if (forrige != null) {
				forrigeIntervall = new MaaleavlesningIntervall(forrige, avlesning, forrigeIntervall);
			}
			forrige = avlesning;
		}
		return forrigeIntervall != null ? forrigeIntervall.getForsteIntervall() : MaaleavlesningIntervall.NULL_INTERVALL;
	}

	public MaaleavlesningIntervall getIntervaller(Datointervall datointervall, Maalepunkt maalepunkt) {
		MaaleavlesningIntervall intervaller = getIntervaller(maalepunkt);
		//sjekker om datointervallet ligger før hele kjeden med avlesningsintervall => bruker det første intervallet for hele beregningen
		if (isTilDatoForDatointervallBeforeForsteAvlesning(datointervall, intervaller)) {
			intervaller.setNesteIntervall(null);
			return intervaller;
		}
		//sjekker om datointervallet ligger etter hele kjeden med avlesningsintervall => bruker det siste intervallet for hele beregningen
		if (isFraDatoForDatointervallAfterSisteAvlesning(datointervall, intervaller)) {
			intervaller = intervaller.getSisteIntervall();
			intervaller.setForrigeIntervall(null);
			return intervaller;
		}
		
		MaaleavlesningIntervall subIntervaller = intervaller;
		//finner start-intervallet
		while (subIntervaller != null 
				&& !datointervall.getFraDato().before(subIntervaller.getAvlesningDatointervall().getFraDato()) //at fra dato ligger får første måling
				&& !subIntervaller.getAvlesningDatointervall().isDateInRange(datointervall.getFraDato())) {
			subIntervaller = subIntervaller.getNesteIntervall();
			subIntervaller.setForrigeIntervall(null);
		}
		
		if (subIntervaller == null) {
			subIntervaller = getIntervaller(maalepunkt);
		}
		
		MaaleavlesningIntervall sisteIntervall = subIntervaller.getSisteIntervall();
		//finner slutt-intervallet
		while (sisteIntervall.getForrigeIntervall() != null
				&& !datointervall.getTilDato().after(sisteIntervall.getAvlesningDatointervall().getTilDato()) //at til dato ligger etter siste måling
				&& !sisteIntervall.getAvlesningDatointervall().isDateInRange(datointervall.getTilDato())) {
			sisteIntervall = sisteIntervall.getForrigeIntervall();
		}
		
		sisteIntervall.setNesteIntervall(null);
		return sisteIntervall.getForsteIntervall();
	}

	boolean isFraDatoForDatointervallAfterSisteAvlesning(Datointervall datointervall,
			MaaleavlesningIntervall intervaller) {
		return datointervall.getFraDato().after(intervaller.getSisteIntervall().getAvlesningDatointervall().getTilDato());
	}

	boolean isTilDatoForDatointervallBeforeForsteAvlesning(Datointervall datointervall,
			MaaleavlesningIntervall intervaller) {
		return datointervall.getTilDato().before(intervaller.getAvlesningDatointervall().getFraDato());
	}
}
