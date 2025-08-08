package com.example.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventmanagement.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    
}
