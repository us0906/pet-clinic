package net.ulrichschulte.lernen.petclinic.model;

import org.springframework.context.annotation.Bean;


public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
