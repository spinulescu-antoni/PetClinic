package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PetOwner {
    @Id
    @GeneratedValue
    private Integer petOwnerId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "petOwner")
    private List<Pet> pets;


    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Integer getPetOwnerId() {
        return petOwnerId;
    }

    public void setPetOwnerId(Integer petOwnerId) {
        this.petOwnerId = petOwnerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
