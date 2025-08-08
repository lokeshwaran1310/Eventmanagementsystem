package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.RegistrationRequestDto;
import com.example.eventmanagement.dto.RegistrationResponseDto;
import java.util.List;

public interface RegistrationService {
    RegistrationResponseDto createRegistration(RegistrationRequestDto registrationRequestDto);
    RegistrationResponseDto getRegistrationById(Long id);
    List<RegistrationResponseDto> getAllRegistrations();
    List<RegistrationResponseDto> getRegistrationsByUserId(Long userId);
    List<RegistrationResponseDto> getRegistrationsByEventId(Long eventId);
    void deleteRegistration(Long id);
}
