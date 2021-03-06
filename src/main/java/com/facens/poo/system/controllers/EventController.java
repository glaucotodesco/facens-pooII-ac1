package com.facens.poo.system.controllers;

import java.net.URI;
import java.time.LocalDate;
import com.facens.poo.system.dto.EventDTO;
import com.facens.poo.system.dto.EventInsertDTO;
import com.facens.poo.system.dto.EventUpdateDTO;
import com.facens.poo.system.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(

            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "description", defaultValue = "") String description,
            @RequestParam(value = "place", defaultValue = "") String place,
            @RequestParam(value = "emailContact", defaultValue = "") String emailContact,
            @RequestParam(value = "startDate", defaultValue = "1900-01-01") LocalDate startDate

    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<EventDTO> list = service.getEvents(pageRequest, name.trim(), description.trim(), place.trim(),
                emailContact.trim(), startDate);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO dto = service.getEventById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> insert(@RequestBody EventInsertDTO insertDTO) {

        EventDTO dto = service.insertEvent(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDTO> update(@RequestBody EventUpdateDTO updateDTO, @PathVariable Long id) {
        EventDTO dto = service.updateEvent(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }
}
