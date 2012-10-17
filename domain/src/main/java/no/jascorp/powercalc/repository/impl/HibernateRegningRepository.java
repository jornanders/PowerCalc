package no.jascorp.powercalc.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import no.jascorp.powercalc.domain.regning.Regning;
import no.jascorp.powercalc.repository.RegningRepository;

/**
 * @author Jørn Anders Svendsen
 *
 */
@Repository
public class HibernateRegningRepository implements RegningRepository {

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void save(Regning regning) {
		factory.getCurrentSession().save(regning);
	}

	@Override
	public Regning get(int regningId) {
		return (Regning) factory.getCurrentSession().get(Regning.class, regningId);
	}
}
