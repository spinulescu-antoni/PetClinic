package org.example.service;

import org.example.entities.Vet;
import org.example.repository.VetRepository;
import org.example.utils.Utils;

import java.util.List;

public class VetService {
    private IOService ioService = new IOService();
    private VetRepository vetRepository = new VetRepository();
    public   void addNewVet(){
        ioService.displayToConsole("What is new vet's first name?");
        String firstName = ioService.getUserInput();
        ioService.displayToConsole("What is new vet's last name?");
        String lastName = ioService.getUserInput();
        Integer badgeId = Utils.generateBadgeId();
        Vet vet = createVet(firstName, lastName, badgeId);
        vetRepository.save(vet);
        ioService.displayToConsole("New vet has been added successfully!");
    }
    public void displayAllVets() {
        ioService.displayToConsole("\nOur pet clinic has the following vets:");
        List<Vet> vetList = vetRepository.getAllVets();
        ioService.displayVets(vetList);
    }
    private Vet createVet(String firstName, String lastName, Integer badgeId){
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        vet.setBadgeId(badgeId);
        return vet;
    }
}
