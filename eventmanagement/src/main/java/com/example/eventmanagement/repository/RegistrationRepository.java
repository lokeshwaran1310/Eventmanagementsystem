package com.example.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eventmanagement.domain.Registrations;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registrations, Long>{
    List<Registrations> findByUserId(Long userId);
    List<Registrations> findByEventId(Long eventId);
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
}
