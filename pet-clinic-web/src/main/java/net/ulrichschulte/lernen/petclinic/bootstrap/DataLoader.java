package net.ulrichschulte.lernen.petclinic.bootstrap;

import net.ulrichschulte.lernen.petclinic.model.Owner;
import net.ulrichschulte.lernen.petclinic.model.Vet;
import net.ulrichschulte.lernen.petclinic.services.OwnerService;
import net.ulrichschulte.lernen.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId (1L);
        owner1.setFirstName("Peter");
        owner1.setLastName("Miller");
        ownerService.save(owner1);
        System.out.println ("Saving owner1");


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mira");
        owner2.setLastName("Troy");
        ownerService.save(owner2);
        System.out.println ("Saving owner2");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("George");
        vet1.setLastName("Bas");
        vetService.save(vet1);

        System.out.println ("Saving vet1");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Paul");
        vet2.setLastName("Jobs");
        vetService.save(vet2);

        System.out.println ("Saving vet2");

    }
}
