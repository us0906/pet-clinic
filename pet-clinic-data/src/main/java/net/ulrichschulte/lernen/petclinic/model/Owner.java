package net.ulrichschulte.lernen.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "owners")
public class Owner extends Person {

    @Column (name="address")
    private String address;

    @Column (name="city")
    private String city;

    @Column (name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address) {
        super(id, firstName, lastName);
        this.address = address;
    }
}
