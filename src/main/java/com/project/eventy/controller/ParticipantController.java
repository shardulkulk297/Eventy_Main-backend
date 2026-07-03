package com.project.eventy.controller;

import com.project.eventy.entity.Participant;
import com.project.eventy.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping("/api/participant/add")
    public ResponseEntity<?> addParticipant(@RequestBody Participant participant){
        return ResponseEntity.status(HttpStatus.CREATED).body(participantService.addParticipant(participant));
    }
}
