package no.jascorp.powercalc.repository;

import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaaleavlesningRepository extends JpaRepository<Maaleavlesning, Integer> {

}

