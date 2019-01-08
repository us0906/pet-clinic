package net.ulrichschulte.lernen.petclinic.repositories;

import net.ulrichschulte.lernen.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

     Owner findByLastName (String lastName);

}
