package com.project.eventy.service;

import com.project.eventy.entity.Participant;
import com.project.eventy.entity.User;
import com.project.eventy.entity.enums.Role;
import com.project.eventy.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    private UserService userService;
    @Autowired
    private ParticipantRepository participantRepository;
    public Participant addParticipant(Participant participant) {
        User user = participant.getUser();
        user.setRole(Role.PARTICIPANT);
        userService.signUp(user);
        return participantRepository.save(participant);
    }
}
