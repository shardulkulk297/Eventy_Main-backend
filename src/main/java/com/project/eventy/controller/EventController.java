package com.project.eventy.controller;

import com.project.eventy.entity.Event;
import com.project.eventy.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/api/event/add")
    public ResponseEntity<?> addEvent(@RequestBody Event event, Principal principal){

        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.addEvent(event));


    }
}
