package net.ulrichschulte.lernen.petclinic.services.springdatajpa;

import net.ulrichschulte.lernen.petclinic.model.Owner;
import net.ulrichschulte.lernen.petclinic.repositories.OwnerRepository;
import net.ulrichschulte.lernen.petclinic.repositories.PetRepository;
import net.ulrichschulte.lernen.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String SMITH = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByLastName() {
        Owner savedOwner = Owner.builder().id(1L).lastName(SMITH).build();
        when (ownerRepository.findByLastName(any())).thenReturn (savedOwner);
        Owner smith = ownerService.findByLastName(SMITH);
        assertEquals(SMITH, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when (ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnedOwner = ownerService.findAll();

        assertNotNull(returnedOwner);
        assertEquals(2, returnedOwner.size());
    }

    @Test
    void findById() {
        Owner returnedOwner = Owner.builder().lastName(SMITH).id(1L).build();

        when (ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));

        Owner owner = ownerService.findById(1L);

        assertNotNull(owner);
        assertEquals(1L,owner.getId().longValue());
        assertEquals(SMITH,owner.getLastName());
    }

    @Test
    void findByIdNotFound() {
        when (ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerService.findById(2L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner returnedOwner = Owner.builder().lastName(SMITH).id(1L).build();

        Owner ownerToSave = Owner.builder().id(1L).build();
        when (ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner savedOwner = ownerService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify (ownerRepository).save(any());

    }

    @Test
    void delete() {
        Owner returnedOwner = Owner.builder().lastName(SMITH).id(1L).build();

        ownerService.delete (returnedOwner);
        verify (ownerRepository, times (1)).delete(any());
    }

    @Test
    void deleteById() {

        ownerService.deleteById (1L);
        verify (ownerRepository, times (1)).deleteById(anyLong());
    }
}