package com.facens.poo.system.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.facens.poo.system.entities.Event;
import com.fasterxml.jackson.annotation.JsonFormat;



public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String place;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    
    private LocalTime startTime;
    private LocalTime endTime;
    private String emailContact;

    public EventDTO()
    {

    }
    
    public EventDTO(Long id, String name)
    {
        setId(id);
        setName(name);
    }
    
    public EventDTO(Event event)
    {
        setId(event.getId());
        setName(event.getName());
        setDescription(event.getDescription());
        setPlace(event.getPlace());
        setStartDate(event.getStartDate());
        setEndDate(event.getEndDate());
        setStartTime(event.getStartTime());
        setEndTime(event.getEndTime());
        setEmailContact(event.getEmailContact());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    

    
}
