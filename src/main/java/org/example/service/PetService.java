package org.example.service;

import org.example.entities.Pet;
import org.example.entities.PetOwner;
import org.example.repository.PetOwnerRepository;
import org.example.repository.PetRepository;
import org.example.utils.Utils;

import java.util.List;
import java.util.Optional;

public class PetService {
    private PetRepository petRepository = new PetRepository();
    private IOService ioService = new IOService();
    private PetOwnerRepository petOwnerRepository = new PetOwnerRepository();
    public void addNewPet(){
        Optional<Pet> optionalPet = createPet();
        if (optionalPet.isPresent()){
            petRepository.save(optionalPet.get());
            ioService.displayToConsole("Pet added succesfully!");
        }else {
            ioService.displayToConsole("Pet owner does not exist");
        }
    }
    public   void displayAllPet(){
        List<Pet> allPets = petRepository.getAllPet();
        ioService.displayAllPet(allPets);
    }
    private Optional<Pet> createPet() {
        Pet pet = new Pet();
        ioService.displayToConsole("What is the pet type?");
        pet.setAnimalType(ioService.getUserInput());
        ioService.displayToConsole("What is the pet name?");
        pet.setName(ioService.getUserInput());
        pet.setCollarId(Utils.generateCollarId());
        ioService.displayToConsole("What is the pet owner's phone number?");
        String phoneNumber= ioService.getUserInput();
        Optional<PetOwner> optionalPetOwner = petOwnerRepository.findByPhoneNumber(phoneNumber);
        if (optionalPetOwner.isEmpty()){
            return Optional.empty();
        }
        pet.setPetOwner(optionalPetOwner.get());
        return Optional.of(pet);
    }

}
