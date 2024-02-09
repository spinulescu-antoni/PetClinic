package org.example.validator;

import org.example.entities.Appointment;
import org.example.entities.Vet;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class AppointmentValidator {

    public boolean isNewAppointmentInvalid(LocalDateTime newDateTime, Vet vet){
        long numberOfConflictingAppointments = vet.getAppointments()
                .stream()
                .map(Appointment::getDateTimea)
                .filter(existingDateTime -> existingDateTime.isAfter(newDateTime.minusMinutes(30)))
                .filter(existingDateTime -> existingDateTime.isBefore(newDateTime.plusMinutes(30)))
                .count();

        System.out.println("Number of conflicting appointments: " + numberOfConflictingAppointments);


        return numberOfConflictingAppointments > 0;
    }
}
