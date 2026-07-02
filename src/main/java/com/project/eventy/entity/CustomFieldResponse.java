package com.project.eventy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "custom_field_responses")
public class CustomFieldResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     One registration can have many custom field responses.
     Example:
     Registration 1 answers:
     - Project Title
     - GitHub Link
     - Team Idea
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_id", nullable = false)
    private Registration registration;

    /*
     The custom field being answered.
     Example:
     customField = "Project Title"
     answer = "AI Resume Screening System"
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_field_id", nullable = false)
    private CustomField customField;

    /*
     Participant's answer.
     Store as String for MVP.
     For NUMBER, DATE, CHECKBOX, etc., convert/validate in service layer.
     */
    @Column(name = "answer", length = 5000)
    private String answer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CustomFieldResponse() {
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Registration getRegistration() {
        return registration;
    }

    public CustomField getCustomField() {
        return customField;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public void setCustomField(CustomField customField) {
        this.customField = customField;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}