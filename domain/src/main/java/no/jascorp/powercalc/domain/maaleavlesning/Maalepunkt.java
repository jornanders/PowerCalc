package no.jascorp.powercalc.domain.maaleavlesning;

import no.jascorp.powercalc.domain.common.Datointervall;

/**
 * @author Jørn Anders Svendsen
 *
 */
public enum Maalepunkt {
	
	HOVEDMAALER(new BeregnForbrukForMaalepunkt() {
		@Override
		public double beregnForbruk(Maaleavlesninger avlesninger, Datointervall intervall) {
			return avlesninger.beregnForbrukForIntervall(intervall, HOVEDMAALER);
		}

		@Override
		public double beregnProsentandel(Maaleavlesninger avlesninger, Datointervall intervall) {
			return 1;
		}
	}),
	HOVEDETASJE(new BeregnForbrukForMaalepunkt() {
		@Override
		public double beregnForbruk(Maaleavlesninger avlesninger, Datointervall intervall) {
			return HOVEDMAALER.beregnForbruk(avlesninger, intervall) - HYBELMAALER.beregnForbruk(avlesninger, intervall);
		}

		@Override
		public double beregnProsentandel(Maaleavlesninger avlesninger, Datointervall intervall) {
			double forbrukHovedmaaler = HOVEDMAALER.beregnForbruk(avlesninger, intervall);
			return (forbrukHovedmaaler - HYBELMAALER.beregnForbruk(avlesninger, intervall)) / forbrukHovedmaaler;
		}
	}),
	HYBELMAALER(new BeregnForbrukForMaalepunkt() {
		@Override
		public double beregnForbruk(Maaleavlesninger avlesninger, Datointervall intervall) {
			return avlesninger.beregnForbrukForIntervall(intervall, HYBELMAALER);
		}

		@Override
		public double beregnProsentandel(Maaleavlesninger avlesninger, Datointervall intervall) {
			return beregnForbruk(avlesninger, intervall) / HOVEDMAALER.beregnForbruk(avlesninger, intervall);
		}
	}),
	
	NULL_VALUE(new BeregnForbrukForMaalepunkt() {
		@Override
		public double beregnForbruk(Maaleavlesninger avlesninger, Datointervall intervall) {
			return 0;
		}

		@Override
		public double beregnProsentandel(Maaleavlesninger avlesninger, Datointervall intervall) {
			return 0;
		}
	});

	private final BeregnForbrukForMaalepunkt beregnCallback;
	
	private Maalepunkt(BeregnForbrukForMaalepunkt beregnCallback) {
		this.beregnCallback = beregnCallback;
	}

	public double beregnForbruk(Maaleavlesninger avlesninger, Datointervall intervall) {
		return beregnCallback.beregnForbruk(avlesninger, intervall);
	}
	
	public double beregnProsentandel(Maaleavlesninger avlesninger, Datointervall intervall) {
		return beregnCallback.beregnProsentandel(avlesninger, intervall);
	}
}

interface BeregnForbrukForMaalepunkt {
	double beregnForbruk(Maaleavlesninger avlesninger, Datointervall intervall);

	double beregnProsentandel(Maaleavlesninger avlesninger, Datointervall intervall);
}
