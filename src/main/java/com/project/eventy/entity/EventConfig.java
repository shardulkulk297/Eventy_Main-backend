package com.project.eventy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="event_config")
public class EventConfig {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Event event;
    private long maxParticipants;
    private long seatLimited;
    private boolean ticketRequired;
    private boolean teamAllowed;
    private int maxTeamSize;
    private int minTeamSize;
    private boolean teamLeaderRequired;
    private boolean approvalRequired;
    private boolean allowedWaitlist;
    private boolean allowedParticipantType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public long getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(long maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public long getSeatLimited() {
        return seatLimited;
    }

    public void setSeatLimited(long seatLimited) {
        this.seatLimited = seatLimited;
    }

    public boolean isTicketRequired() {
        return ticketRequired;
    }

    public void setTicketRequired(boolean ticketRequired) {
        this.ticketRequired = ticketRequired;
    }

    public boolean isTeamAllowed() {
        return teamAllowed;
    }

    public void setTeamAllowed(boolean teamAllowed) {
        this.teamAllowed = teamAllowed;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(int maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    public int getMinTeamSize() {
        return minTeamSize;
    }

    public void setMinTeamSize(int minTeamSize) {
        this.minTeamSize = minTeamSize;
    }

    public boolean isTeamLeaderRequired() {
        return teamLeaderRequired;
    }

    public void setTeamLeaderRequired(boolean teamLeaderRequired) {
        this.teamLeaderRequired = teamLeaderRequired;
    }

    public boolean isApprovalRequired() {
        return approvalRequired;
    }

    public void setApprovalRequired(boolean approvalRequired) {
        this.approvalRequired = approvalRequired;
    }

    public boolean isAllowedWaitlist() {
        return allowedWaitlist;
    }

    public void setAllowedWaitlist(boolean allowedWaitlist) {
        this.allowedWaitlist = allowedWaitlist;
    }

    public boolean isAllowedParticipantType() {
        return allowedParticipantType;
    }

    public void setAllowedParticipantType(boolean allowedParticipantType) {
        this.allowedParticipantType = allowedParticipantType;
    }


    


}
