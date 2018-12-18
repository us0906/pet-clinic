package net.ulrichschulte.lernen.petclinic.bootstrap;

import net.ulrichschulte.lernen.petclinic.model.Owner;
import net.ulrichschulte.lernen.petclinic.model.PetType;
import net.ulrichschulte.lernen.petclinic.model.Vet;
import net.ulrichschulte.lernen.petclinic.services.OwnerService;
import net.ulrichschulte.lernen.petclinic.services.PetTypeService;
import net.ulrichschulte.lernen.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName ("Dog");
        PetType savedDogType = petTypeService.save (dog);
        System.out.println("Saving dogType");

        PetType cat = new PetType();
        dog.setName ("Cat");
        PetType savedCatType = petTypeService.save (cat);
        System.out.println("Saving catType");


        Owner owner1 = new Owner();
        owner1.setFirstName("Peter");
        owner1.setLastName("Miller");
        ownerService.save(owner1);
        System.out.println ("Saving owner1");


        Owner owner2 = new Owner();
        owner2.setFirstName("Mira");
        owner2.setLastName("Troy");
        ownerService.save(owner2);
        System.out.println ("Saving owner2");

        Vet vet1 = new Vet();
        vet1.setFirstName("George");
        vet1.setLastName("Bas");
        vetService.save(vet1);

        System.out.println ("Saving vet1");

        Vet vet2 = new Vet();
        vet2.setFirstName("Paul");
        vet2.setLastName("Jobs");
        vetService.save(vet2);

        System.out.println ("Saving vet2");

    }
}
