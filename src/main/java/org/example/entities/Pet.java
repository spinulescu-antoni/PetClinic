package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Integer petId;
    private String name;
    private String animalType;
    @Column(unique = true)
    private String collarId;
    @ManyToOne
    @JoinColumn
    private PetOwner petOwner;
    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getCollarId() {
        return collarId;
    }

    public void setCollarId(String collarId) {
        this.collarId = collarId;
    }

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }
}


