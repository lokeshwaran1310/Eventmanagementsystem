package com.example.eventmanagement.mapper;

import com.example.eventmanagement.domain.Event;
import com.example.eventmanagement.dto.EventRequestDto;
import com.example.eventmanagement.dto.EventResponseDto;

public class EventMapper {
    
    public static Event toEvent(EventRequestDto eventRequestDto) {
        Event event = new Event();
        event.setTitle(eventRequestDto.getTitle());
        event.setDescription(eventRequestDto.getDescription());
        event.setDate(eventRequestDto.getDate());
        event.setLocation(eventRequestDto.getLocation());
        return event;
    }
    
    public static EventResponseDto toEventResponseDto(Event event) {
        EventResponseDto eventDto = new EventResponseDto();
        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setDate(event.getDate());
        eventDto.setLocation(event.getLocation());
        return eventDto;
    }
}
