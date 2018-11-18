package net.ulrichschulte.lernen.petclinic.services;

import net.ulrichschulte.lernen.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById (Long id);

    Vet save (Vet owner);

    Set<Vet> findAll();
}
