package net.ulrichschulte.lernen.petclinic.services;

import net.ulrichschulte.lernen.petclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService extends CrudService<Visit, Long> {

}
