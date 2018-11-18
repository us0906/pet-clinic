package net.ulrichschulte.lernen.petclinic.services;

import net.ulrichschulte.lernen.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById (Long id);

    Pet save (Pet owner);

    Set<Pet> findAll();
}
