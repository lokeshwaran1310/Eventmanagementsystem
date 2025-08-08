package com.example.eventmanagement.service;

import com.example.eventmanagement.dto.EventRequestDto;
import com.example.eventmanagement.dto.EventResponseDto;
import java.util.List;

public interface EventService {
    EventResponseDto createEvent(EventRequestDto eventRequestDto);
    EventResponseDto getEventById(Long id);
    List<EventResponseDto> getAllEvents();
    EventResponseDto updateEvent(Long id, EventRequestDto eventRequestDto);
    void deleteEvent(Long id);
}
