package com.project.eventy.entity;

import java.time.LocalDateTime;

import com.project.eventy.entity.enums.EventType;
import com.project.eventy.entity.enums.RegistrationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import javafx.util.converter.LocalDateStringConverter;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private EventType eventType;
    private RegistrationType registrationType;
    private String Visibility;
    private String Status;
    @ManyToOne
    private Organization organization;
    @ManyToOne
    private Committee committee;
    @OneToOne
    private EventManager createdBy;
    private boolean online;
    private String meetingLink;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private LocalDateTime registrationStartDateTime;
    private LocalDateTime registrationEndDataTime;
    private String bannerImageUrl;
    private boolean active;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public RegistrationType getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(RegistrationType registrationType) {
        this.registrationType = registrationType;
    }

    public String getVisibility() {
        return Visibility;
    }

    public void setVisibility(String Visibility) {
        this.Visibility = Visibility;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
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

    public EventManager getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(EventManager createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }

    public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public LocalDateTime getRegistrationStartDateTime() {
        return registrationStartDateTime;
    }

    public void setRegistrationStartDateTime(LocalDateTime registrationStartDateTime) {
        this.registrationStartDateTime = registrationStartDateTime;
    }

    public LocalDateTime getRegistrationEndDataTime() {
        return registrationEndDataTime;
    }

    public void setRegistrationEndDataTime(LocalDateTime registrationEndDataTime) {
        this.registrationEndDataTime = registrationEndDataTime;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public void setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
