package com.project.eventy.controller;

import com.project.eventy.entity.EventManager;
import com.project.eventy.service.EventManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventManagerController {
    @Autowired
    private EventManagerService eventManagerService;

    @PostMapping("/api/eventManager/add")
    public ResponseEntity<?> addEventManager(@RequestBody EventManager eventManager){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventManagerService.addEventManager(eventManager));
    }





    
    
}
