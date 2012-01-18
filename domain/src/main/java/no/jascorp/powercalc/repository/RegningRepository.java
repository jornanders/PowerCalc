package no.jascorp.powercalc.repository;

import no.jascorp.powercalc.domain.regning.Regning;

public interface RegningRepository {
	public void save(Regning regning);
	public Regning get(int regningId);
}
