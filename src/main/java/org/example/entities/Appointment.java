package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Integer appointmentId;
    @ManyToOne
    @JoinColumn
    private Vet vet;
    private LocalDateTime dateTimea;
    @ManyToOne
    @JoinColumn
    private Pet pet;


    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public LocalDateTime getDateTimea() {
        return dateTimea;
    }

    public void setDateTimea(LocalDateTime dateTimea) {
        this.dateTimea = dateTimea;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
