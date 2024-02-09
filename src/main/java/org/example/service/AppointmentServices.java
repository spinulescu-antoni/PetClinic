package org.example.service;

import org.example.entities.Appointment;
import org.example.entities.Pet;
import org.example.entities.Vet;
import org.example.exception.InvalidDateTimeException;
import org.example.exception.InvalidInputException;
import org.example.exception.NoPetsFoundFOrPhoneNumberException;
import org.example.exception.SomethingWentWrongException;
import org.example.repository.AppointmentRepository;
import org.example.repository.PetRepository;
import org.example.repository.VetRepository;
import org.example.utils.Utils;
import org.example.validator.AppointmentValidator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class AppointmentServices {
    private IOService ioService = new IOService();
    private PetRepository petRepository = new PetRepository();
    private VetRepository vetRepository = new VetRepository();
    private AppointmentValidator appointmentValidator = new AppointmentValidator();
    private AppointmentRepository appointmentRepository = new AppointmentRepository();

    public void addNewAppointment() {

        try {
            Pet selectedPet = obtainSelectedPet();
            Vet selectedVet = obtainSelectedVet();
            LocalDateTime appointmentDateTime = obtainSelectedDayTime();
            if(appointmentValidator.isNewAppointmentInvalid(appointmentDateTime, selectedVet)){
                ioService.displayToConsole("Sorry the vet is not available at this date and time!");
                return;
            }
            Appointment appointment = createAppointmentObject(appointmentDateTime, selectedVet, selectedPet);
            save(appointment);
            ioService.displayToConsole("Your appointment has successfully added!");
        } catch (NoPetsFoundFOrPhoneNumberException exception) {
            ioService.displayToConsole("Sorry the phone number doesn't have any pets!");
        } catch (InvalidInputException e) {
            ioService.displayToConsole("Sorry the input is not valid!");
        } catch (InvalidDateTimeException e) {
            ioService.displayToConsole("Sorry the date and the time is not valid!");
        } catch (SomethingWentWrongException e) {
            ioService.displayToConsole("Sorry something went wrong!\nPlease try again!");
        }
    }

    private void save(Appointment appointment) throws SomethingWentWrongException {
        try {
            appointmentRepository.save(appointment);
        }catch (Exception e){
            throw new SomethingWentWrongException();
        }

    }

    private static Appointment createAppointmentObject(LocalDateTime dateAndTime, Vet selectedVet, Pet selectedPet) {
        Appointment appointment = new Appointment();
        appointment.setDateTimea(dateAndTime);
        appointment.setVet(selectedVet);
        appointment.setPet(selectedPet);
        return appointment;
    }

    private LocalDateTime obtainSelectedDayTime() throws InvalidDateTimeException {
        ioService.displayToConsole("What is the date of your appointment?");
        String appointmentDate = ioService.getUserInput();
        ioService.displayToConsole("What is the time of your appointment?");
        String appointmentTimne = ioService.getUserInput();
        LocalDateTime dateAndTime = Utils.convertToDateTime(appointmentDate, appointmentTimne);
        return dateAndTime;
    }

    private Vet obtainSelectedVet() throws InvalidInputException {
        List<Vet> vetList = vetRepository.getAllVets();
        ioService.displayVetOption(vetList);
        String vetNumber = ioService.getUserInput();
        try {
            return vetList.get(Integer.parseInt(vetNumber) - 1);
        }catch (Exception e){
            throw new InvalidInputException();
        }

    }

    private Pet obtainSelectedPet() throws NoPetsFoundFOrPhoneNumberException, InvalidInputException {
        ioService.displayToConsole("What is your phone number?");
        String ownerPhoneNumber = ioService.getUserInput();
        List <Pet> petList = petRepository.findByOwnerPhoneNumber(ownerPhoneNumber);
        if (petList.isEmpty()){
            throw new NoPetsFoundFOrPhoneNumberException();
        }
        ioService.displayPetOption(petList);
        String petNumber = ioService.getUserInput();
        try {
            return petList.get(Integer.parseInt(petNumber) - 1);
        }catch (Exception e){
            throw new InvalidInputException();
        }

    }
}
