package com.example.eventmanagement.mapper;

import com.example.eventmanagement.domain.Registrations;
import com.example.eventmanagement.domain.User;
import com.example.eventmanagement.domain.Event;
import com.example.eventmanagement.dto.RegistrationRequestDto;
import com.example.eventmanagement.dto.RegistrationResponseDto;

public class RegistrationsMapper {
    
    public static Registrations toRegistration(RegistrationRequestDto registrationDto, User user, Event event) {
        Registrations registration = new Registrations();
        registration.setUser(user);
        registration.setEvent(event);
        registration.setRegistrationDate(java.time.LocalDate.now());
        return registration;
    }
    
    public static RegistrationResponseDto toRegistrationResponseDto(Registrations registration) {
        RegistrationResponseDto registrationDto = new RegistrationResponseDto();
        registrationDto.setId(registration.getId());
        registrationDto.setUserId(registration.getUser().getId());
        registrationDto.setUserName(registration.getUser().getName());
        registrationDto.setEventId(registration.getEvent().getId());
        registrationDto.setEventTitle(registration.getEvent().getTitle());
        registrationDto.setRegistrationDate(registration.getRegistrationDate());
        return registrationDto;
    }
}
