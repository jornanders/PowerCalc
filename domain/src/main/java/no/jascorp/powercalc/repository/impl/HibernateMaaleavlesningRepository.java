package no.jascorp.powercalc.repository.impl;

import java.util.List;

import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.repository.MaaleavlesningRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateMaaleavlesningRepository implements MaaleavlesningRepository {
	
	private SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void save(Maaleavlesning maaleavlesning) {
		if (maaleavlesning == Maaleavlesning.NULL_AVLESNING) {
			throw new IllegalArgumentException("Kan ikke lagre NULL_AVLESNING");
		}
		assureStandIsIncreasing(maaleavlesning);
		factory.getCurrentSession().save(maaleavlesning);
	}

	public Maaleavlesning get(int id) {
		return (Maaleavlesning) factory.getCurrentSession().get(Maaleavlesning.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Maaleavlesninger getMaaleavlesninger() {
		List<Maaleavlesning> avlesninger = factory.getCurrentSession().createCriteria(Maaleavlesning.class).list();
		return new Maaleavlesninger(avlesninger);
	}
	
	private void assureStandIsIncreasing(Maaleavlesning maaleavlesning) {
		getMaaleavlesninger().addMaaleavlesning(maaleavlesning);
	}
}
