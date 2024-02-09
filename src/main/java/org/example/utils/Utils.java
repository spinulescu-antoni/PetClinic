package org.example.utils;

import org.example.exception.InvalidDateTimeException;
import org.example.exception.InvalidInputException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Utils {
    public static Integer generateBadgeId(){
        Random random = new Random();
        Integer badgeId = random.nextInt(1,10000);
        return badgeId;
    }

    public static String generateCollarId() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < 4; index++){
            char randomChar = (char) random.nextInt(65,91);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
    public static LocalDateTime convertToDateTime(String appointmentDate, String appointmentTimne) throws InvalidDateTimeException {
        try {
            LocalDate localDate = LocalDate.parse(appointmentDate);
            LocalTime localTime = LocalTime.parse(appointmentTimne);
            LocalDateTime dateAndTime = LocalDateTime.of(localDate, localTime);
            return dateAndTime;
        }catch (Exception e){
            throw new InvalidDateTimeException();
        }
    }
}
