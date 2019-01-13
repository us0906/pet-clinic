package net.ulrichschulte.lernen.petclinic.services.map;

import net.ulrichschulte.lernen.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    public static final String SMITH = "smith";
    OwnerMapService ownerMapService;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save (Owner.builder().id(ownerId).firstName("peter").lastName(SMITH).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }


    @Test
    void findById() {
    }

    @Test
    void saveNoId() {
        Owner savedOwner =  ownerMapService.save (Owner.builder().firstName("paul").lastName("sneider").build());
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveExistingId() {
        Long newId = 2L;
        Owner savedOwner = ownerMapService.save (Owner.builder().id(newId).firstName("peter").lastName("Smith").build());
        assertEquals ( newId, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete (ownerMapService.findById(ownerId));
        assertEquals (0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById (ownerId);
        assertEquals (0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(SMITH);
        assertNotNull(owner);
        assertEquals(SMITH, owner.getLastName());
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameUnknown() {
        Owner owner = ownerMapService.findByLastName("xxxx");
        assertNull(owner);
    }
}