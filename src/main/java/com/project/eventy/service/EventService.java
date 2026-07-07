package com.project.eventy.service;

import com.project.eventy.entity.Committee;
import com.project.eventy.entity.Event;
import com.project.eventy.entity.Organization;
import com.project.eventy.exception.ResourceNotFoundException;
import com.project.eventy.repository.CommitteeRepository;
import com.project.eventy.repository.EventManagerRepository;
import com.project.eventy.repository.EventRepository;
import com.project.eventy.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private CommitteeRepository committeeRepository;
    @Autowired
    private EventManagerRepository eventManagerRepository;
    @Autowired
    public Event addEvent(Event event, String username) {

        Organization organization = event.getOrganization();
        Committee committee = event.getCommittee();
        event.setCreatedBy(eventManagerRepository.getByUsername(username));
        event.setCommittee(committeeRepository.findById(committee.getId()).orElseThrow(()-> new ResourceNotFoundException("Committee Not Found")));
        event.setOrganization(organizationRepository.findById(organization.getId()).orElseThrow(()->new ResourceNotFoundException("Organization not found")));
        event.setActive(true);
        event.setOnline(true);
        
        return eventRepository.save(event);
    }
}
