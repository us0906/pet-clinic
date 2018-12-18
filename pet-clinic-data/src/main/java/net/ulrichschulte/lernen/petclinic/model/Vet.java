package net.ulrichschulte.lernen.petclinic.model;

import org.springframework.context.annotation.Bean;


public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
