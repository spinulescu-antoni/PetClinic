package org.example.validator;

import org.example.repository.PetOwnerRepository;

public class PetOwnerValidator {
    private PetOwnerRepository petOwnerRepository = new PetOwnerRepository();
    public boolean isPhoneNumberValid(String  phoneNumber) {
        if (null == phoneNumber || phoneNumber.length() != 10) {
            return false;
        }
        if (phoneNumber.charAt(0) != '4' && phoneNumber.charAt(0) != '0')
            return false;
        if (petOwnerRepository.findByPhoneNumber(phoneNumber).isPresent()){
            return false;
        }

        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
