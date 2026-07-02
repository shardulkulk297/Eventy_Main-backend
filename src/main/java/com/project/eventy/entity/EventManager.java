package com.project.eventy.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="event_manager")
public class EventManager {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private User user;
    @ManyToOne
    private Organization organization;
    @ManyToOne
    private Committee committee;
    private String designation;
    private String canCreateEvent;
    private String canUpdateEvent;
    private String canCancelEvent;
    private String canViewRegistrations;
    private String canExportRegistrations;
    private boolean approvedByAdmin;
    private boolean active;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCanCreateEvent() {
        return canCreateEvent;
    }

    public void setCanCreateEvent(String canCreateEvent) {
        this.canCreateEvent = canCreateEvent;
    }

    public String getCanUpdateEvent() {
        return canUpdateEvent;
    }

    public void setCanUpdateEvent(String canUpdateEvent) {
        this.canUpdateEvent = canUpdateEvent;
    }

    public String getCanCancelEvent() {
        return canCancelEvent;
    }

    public void setCanCancelEvent(String canCancelEvent) {
        this.canCancelEvent = canCancelEvent;
    }

    public String getCanViewRegistrations() {
        return canViewRegistrations;
    }

    public void setCanViewRegistrations(String canViewRegistrations) {
        this.canViewRegistrations = canViewRegistrations;
    }

    public String getCanExportRegistrations() {
        return canExportRegistrations;
    }

    public void setCanExportRegistrations(String canExportRegistrations) {
        this.canExportRegistrations = canExportRegistrations;
    }

    public boolean isApprovedByAdmin() {
        return approvedByAdmin;
    }

    public void setApprovedByAdmin(boolean approvedByAdmin) {
        this.approvedByAdmin = approvedByAdmin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
