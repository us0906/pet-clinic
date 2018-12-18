package net.ulrichschulte.lernen.petclinic.model;

import org.springframework.context.annotation.Bean;

import java.util.Set;


public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
