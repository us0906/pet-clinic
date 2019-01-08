package net.ulrichschulte.lernen.petclinic.repositories;

import net.ulrichschulte.lernen.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName (String lastName);
}
