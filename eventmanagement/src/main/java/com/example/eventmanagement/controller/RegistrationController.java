package com.example.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.eventmanagement.dto.RegistrationRequestDto;
import com.example.eventmanagement.dto.RegistrationResponseDto;
import com.example.eventmanagement.service.RegistrationService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationResponseDto> createRegistration(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) {
        RegistrationResponseDto createdRegistration = registrationService.createRegistration(registrationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRegistration);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationResponseDto> getRegistrationById(@PathVariable Long id) {
        RegistrationResponseDto registration = registrationService.getRegistrationById(id);
        return ResponseEntity.ok(registration);
    }

    @GetMapping
    public ResponseEntity<List<RegistrationResponseDto>> getAllRegistrations() {
        List<RegistrationResponseDto> registrations = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RegistrationResponseDto>> getRegistrationsByUserId(@PathVariable Long userId) {
        List<RegistrationResponseDto> registrations = registrationService.getRegistrationsByUserId(userId);
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<RegistrationResponseDto>> getRegistrationsByEventId(@PathVariable Long eventId) {
        List<RegistrationResponseDto> registrations = registrationService.getRegistrationsByEventId(eventId);
        return ResponseEntity.ok(registrations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
