package com.example.eventmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.eventmanagement.domain.Registrations;
import com.example.eventmanagement.domain.User;
import com.example.eventmanagement.domain.Event;
import com.example.eventmanagement.dto.RegistrationRequestDto;
import com.example.eventmanagement.dto.RegistrationResponseDto;
import com.example.eventmanagement.mapper.RegistrationsMapper;
import com.example.eventmanagement.repository.RegistrationRepository;
import com.example.eventmanagement.repository.UserRepository;
import com.example.eventmanagement.repository.EventRepository;
import com.example.eventmanagement.exceptions.ResourceNotFoundException;
import com.example.eventmanagement.exceptions.DuplicateResourceException;
import com.example.eventmanagement.exceptions.InvalidRequestException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EventRepository eventRepository;

    @Override
    public RegistrationResponseDto createRegistration(RegistrationRequestDto registrationRequestDto) {
        if (registrationRequestDto.getUserId() == null || registrationRequestDto.getUserId() <= 0) {
            throw new InvalidRequestException("Invalid user ID provided");
        }
        if (registrationRequestDto.getEventId() == null || registrationRequestDto.getEventId() <= 0) {
            throw new InvalidRequestException("Invalid event ID provided");
        }
        
        User user = userRepository.findById(registrationRequestDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + registrationRequestDto.getUserId()));
        Event event = eventRepository.findById(registrationRequestDto.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + registrationRequestDto.getEventId()));
    
        if (registrationRepository.existsByUserIdAndEventId(registrationRequestDto.getUserId(), registrationRequestDto.getEventId())) {
            throw new DuplicateResourceException("User is already registered for this event");
        }
        
        Registrations registration = RegistrationsMapper.toRegistration(registrationRequestDto, user, event);
        Registrations savedRegistration = registrationRepository.save(registration);
        return RegistrationsMapper.toRegistrationResponseDto(savedRegistration);
    }

    @Override
    public RegistrationResponseDto getRegistrationById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidRequestException("Invalid registration ID provided");
        }
        Registrations registration = registrationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not found with id: " + id));
        return RegistrationsMapper.toRegistrationResponseDto(registration);
    }

    @Override
    public List<RegistrationResponseDto> getAllRegistrations() {
        return registrationRepository.findAll().stream()
                .map(RegistrationsMapper::toRegistrationResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> getRegistrationsByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new InvalidRequestException("Invalid user ID provided");
        }
        return registrationRepository.findByUserId(userId).stream()
                .map(RegistrationsMapper::toRegistrationResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> getRegistrationsByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new InvalidRequestException("Invalid event ID provided");
        }
        return registrationRepository.findByEventId(eventId).stream()
                .map(RegistrationsMapper::toRegistrationResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRegistration(Long id) {
        if (!registrationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Registration not found with id: " + id);
        }
        registrationRepository.deleteById(id);
    }
}
