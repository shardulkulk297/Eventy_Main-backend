package com.project.eventy.service;

import com.project.eventy.entity.Event;
import com.project.eventy.entity.EventManager;
import com.project.eventy.entity.User;
import com.project.eventy.entity.enums.Role;
import com.project.eventy.repository.EventManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventManagerService {
    @Autowired
    private UserService userService;
    @Autowired
    private EventManagerRepository eventManagerRepository;

    public EventManager addEventManager(EventManager eventManager) {

        User user = eventManager.getUser();
        user.setRole(Role.EVENT_MANAGER);
        eventManager.setUser(userService.signUp(user));
        return eventManagerRepository.save(eventManager);
    }
}
