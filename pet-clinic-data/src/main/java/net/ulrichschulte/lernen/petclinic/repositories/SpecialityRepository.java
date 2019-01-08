package net.ulrichschulte.lernen.petclinic.repositories;

import net.ulrichschulte.lernen.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
