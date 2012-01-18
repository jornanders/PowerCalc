package no.jascorp.powercalc.repository;

import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;

public interface MaaleavlesningRepository {
	
	public void save(Maaleavlesning transientInstance);
	
	public Maaleavlesning get(int id);

	public Maaleavlesninger getMaaleavlesninger();
}
