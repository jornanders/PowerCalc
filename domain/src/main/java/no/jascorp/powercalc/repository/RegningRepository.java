package no.jascorp.powercalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import no.jascorp.powercalc.domain.regning.Regning;

/**
 * @author Jørn Anders Svendsen
 */
public interface RegningRepository extends JpaRepository<Regning, Integer> {
}
