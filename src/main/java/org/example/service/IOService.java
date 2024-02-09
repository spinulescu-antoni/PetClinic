package org.example.service;

import org.example.entities.Pet;
import org.example.entities.PetOwner;
import org.example.entities.Vet;

import java.util.List;
import java.util.Scanner;

public class IOService {
     public void displayMenu(){
        displayToConsole("\nWelcome to the pet clinic!");
        displayToConsole("Please chose one of the following option");
        displayToConsole("1 - add new vet;");
        displayToConsole("2 - view all vets;");
        displayToConsole("3 - add new pet owner;");
        displayToConsole("4 - display all pet owners;");
        displayToConsole("5 - add new pet;");
        displayToConsole("6 - display all pets;");
        displayToConsole("7 - add an appointment;");


    }
    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        displayToConsoleInLine("Your answer: ");
        String userInput = scanner.nextLine();
        return userInput;
    }
    public void displayToConsole(String text){
        System.out.println(text);
    }
    public void displayToConsoleInLine(String text){
        System.out.print(text);
    }
    public void displayVets(List<Vet> vetList){
         for (Vet vet : vetList){
             System.out.println(vet.getFirstName() + " " + vet.getLastName() + " " + vet.getBadgeId());
         }
    }

    public void displayPetOwners(List<PetOwner> petOwnerList) {
       petOwnerList.forEach(this::displayPetOwner);
    }

    private void displayPetOwner(PetOwner petOwner){
        System.out.println(petOwner.getFirstName() + " " + petOwner.getLastName() + " " + petOwner.getPhoneNumber());
    }
    public void displayAllPet(List<Pet> allPets) {
        System.out.println("\nWe have the following pets:");
        for (Pet pet : allPets){
            System.out.println("\nPet name: " + pet.getName() + ",\nPet type: " + pet.getAnimalType() + "\nPet collarId: "
                    + pet.getCollarId() + "\nPet owner's name: " + pet.getPetOwner().getFirstName());
        }
    }
    public void displayPetOption(List<Pet> petList){
        System.out.println("Please select the number of your pet: ");
        for (int index = 0; index < petList.size(); index++){
            System.out.println(index + 1 + " " + petList.get(index).getName());
        }
    }
    public void displayVetOption (List<Vet> vetList){
        System.out.println("Please select the number of you vet");
        for (int index = 0; index < vetList.size(); index++){
            System.out.println(index + 1 + " " + vetList.get(index).getFirstName() + " " + vetList.get(index).getLastName());
        }
    }

}
