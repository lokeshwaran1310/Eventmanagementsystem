package com.example.eventmanagement.dto;

import jakarta.validation.constraints.NotNull;

public class RegistrationRequestDto {

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @NotNull(message = "Event ID is mandatory")
    private Long eventId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }


}