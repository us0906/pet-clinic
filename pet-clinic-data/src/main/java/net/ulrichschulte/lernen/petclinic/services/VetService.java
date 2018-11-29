package net.ulrichschulte.lernen.petclinic.services;

import net.ulrichschulte.lernen.petclinic.model.Vet;
import org.springframework.stereotype.Service;

@Service
public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName (String lastName);
}
