package net.ulrichschulte.lernen.petclinic.repositories;

import net.ulrichschulte.lernen.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
