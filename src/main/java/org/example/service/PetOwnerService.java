package org.example.service;

import org.example.entities.PetOwner;
import org.example.repository.PetOwnerRepository;
import org.example.validator.PetOwnerValidator;

import java.util.List;

public class PetOwnerService {
    private PetOwnerRepository petOwnerRepository = new PetOwnerRepository();
    private IOService ioService = new IOService();
    private PetOwnerValidator petOwnerValidator = new PetOwnerValidator();

    public void addNewPetOwner(){
        ioService.displayToConsole("What is the pet owner first name?");
        String firstName = ioService.getUserInput();
        ioService.displayToConsole("What is the pet owner last name?");
        String lastName = ioService.getUserInput();
        String phoneNumber = null;
        while (true){
            ioService.displayToConsole("What is the phone number of pet owner?");
            phoneNumber = ioService.getUserInput();
            if (petOwnerValidator.isPhoneNumberValid(phoneNumber)){
                break;
            }
            ioService.displayToConsole("Sorry your phone number is not valid");
        }
        PetOwner petOwner = createPetOwner(firstName, lastName, phoneNumber);
        petOwnerRepository.save(petOwner);
        ioService.displayToConsole("New pet owner has been added successfully!");
        //        de facut un mecanism care imi da sansa sa reintroduc nr de telefon la infinit pana cand nr de telefon este valid
//        si se adauga pet owner-ul
    }
    public void displayAllPetOwners(){
        ioService.displayToConsole("\nWe have the following pet owners:");
        List<PetOwner> petOwnerList = petOwnerRepository.getAllPetOwners();
        ioService.displayPetOwners(petOwnerList);
    }
    private PetOwner createPetOwner(String firstName, String lastname, String phoneNumber){
        PetOwner petOwner = new PetOwner();
        petOwner.setFirstName(firstName);
        petOwner.setLastName(lastname);
        petOwner.setPhoneNumber(phoneNumber);
        return petOwner;
    }

}
