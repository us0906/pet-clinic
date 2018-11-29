package net.ulrichschulte.lernen.petclinic.services;

import net.ulrichschulte.lernen.petclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends CrudService<Pet, Long> {

    Pet findByLastName (String lastName);
}
