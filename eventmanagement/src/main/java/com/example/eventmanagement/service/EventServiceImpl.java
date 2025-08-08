package com.example.eventmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventmanagement.domain.Event;
import com.example.eventmanagement.dto.EventRequestDto;
import com.example.eventmanagement.dto.EventResponseDto;
import com.example.eventmanagement.exceptions.InvalidRequestException;
import com.example.eventmanagement.exceptions.ResourceNotFoundException;
import com.example.eventmanagement.mapper.EventMapper;
import com.example.eventmanagement.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventResponseDto createEvent(EventRequestDto eventRequestDto) {
        if (eventRequestDto.getDate() != null && eventRequestDto.getDate().isBefore(LocalDate.now())) {
            throw new InvalidRequestException("Event date must be in the future");
        }
        
        Event event = EventMapper.toEvent(eventRequestDto);
        Event savedEvent = eventRepository.save(event);
        return EventMapper.toEventResponseDto(savedEvent);
    }

    @Override
    public EventResponseDto getEventById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidRequestException("Invalid event ID provided");
        }
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return EventMapper.toEventResponseDto(event);
    }

    @Override
    public List<EventResponseDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(EventMapper::toEventResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponseDto updateEvent(Long id, EventRequestDto eventRequestDto) {
        if (id == null || id <= 0) {
            throw new InvalidRequestException("Invalid event ID provided");
        }
        
        // Additional date validation in service layer
        if (eventRequestDto.getDate() != null && eventRequestDto.getDate().isBefore(LocalDate.now())) {
            throw new InvalidRequestException("Event date must be in the future");
        }
        
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        event.setTitle(eventRequestDto.getTitle());
        event.setDescription(eventRequestDto.getDescription());
        event.setDate(eventRequestDto.getDate());
        event.setLocation(eventRequestDto.getLocation());
        Event updatedEvent = eventRepository.save(event);
        return EventMapper.toEventResponseDto(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
}
