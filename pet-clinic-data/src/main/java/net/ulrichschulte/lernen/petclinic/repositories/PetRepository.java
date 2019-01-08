package net.ulrichschulte.lernen.petclinic.repositories;

import net.ulrichschulte.lernen.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
