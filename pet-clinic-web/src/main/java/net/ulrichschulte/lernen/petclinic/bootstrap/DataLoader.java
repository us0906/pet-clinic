package net.ulrichschulte.lernen.petclinic.bootstrap;

import net.ulrichschulte.lernen.petclinic.model.*;
import net.ulrichschulte.lernen.petclinic.services.OwnerService;
import net.ulrichschulte.lernen.petclinic.services.PetTypeService;
import net.ulrichschulte.lernen.petclinic.services.SpecialityService;
import net.ulrichschulte.lernen.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName ("Dog");
        PetType savedDogType = petTypeService.save (dog);
        System.out.println("Saving dogType");

        PetType cat = new PetType();
        dog.setName ("Cat");
        PetType savedCatType = petTypeService.save (cat);
        System.out.println("Saving catType");

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Miller");
        owner1.setAddress("123 Main street");
        owner1.setCity("San Francisco");
        owner1.setTelephone("123 456 789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate( LocalDate.now());
        mikesPet.setName ("Rosco");
        owner1.getPets().add (mikesPet);
        ownerService.save(owner1);

        System.out.println ("Saving owner1");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Troy");
        owner2.setAddress("123 Main street");
        owner2.setCity("San Francisco");
        owner2.setTelephone("123 456 789");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatType);
        fionasCat.setOwner(owner1);
        fionasCat.setBirthDate( LocalDate.now());
        fionasCat.setName ("Drools");
        owner2.getPets().add (fionasCat);
        ownerService.save(owner2);
        System.out.println ("Saving owner2");

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);


        Vet vet1 = new Vet();
        vet1.setFirstName("George");
        vet1.setLastName("Bas");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        System.out.println ("Saving vet1");

        Vet vet2 = new Vet();
        vet2.setFirstName("Paul");
        vet2.setLastName("Jobs");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println ("Saving vet2");
    }
}
