package org.example;

import org.example.service.*;

public class PetClinic {
    private IOService ioService = new IOService();
    private VetService vetService = new VetService();
    private PetService petService = new PetService();
    private PetOwnerService petOwnerService = new PetOwnerService();
    private AppointmentServices appointmentServices = new AppointmentServices();
    public void start(){
        while (true){
//            Pasul 1 : afisam meniul.
            ioService.displayMenu();
//            Pasul 2 : luam Input de la utilizator.
            String userInput = ioService.getUserInput();
//            Pasul 3 : procesam Inputul.
            process(userInput);
        }
    }
    //returneaza un string de la tastatura
    private void process (String userInput) {

        switch (userInput) {
            case "0" -> ioService.displayToConsole("Thank you for visiting ");
            case "1" -> vetService.addNewVet();
            case "2" -> vetService.displayAllVets();
            case "3" -> petOwnerService.addNewPetOwner();
            case "4" -> petOwnerService.displayAllPetOwners();
            case "5" -> petService.addNewPet();
            case "6" -> petService.displayAllPet();
            case "7" -> appointmentServices.addNewAppointment();
        }
    }
}
