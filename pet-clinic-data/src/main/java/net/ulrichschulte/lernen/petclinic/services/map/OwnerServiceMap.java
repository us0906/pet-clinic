package net.ulrichschulte.lernen.petclinic.services.map;

import net.ulrichschulte.lernen.petclinic.model.Owner;
import net.ulrichschulte.lernen.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return (Owner) super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return (Owner) super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
