package com.project.eventy.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.project.eventy.entity.enums.CustomFieldType;

import jakarta.persistence.Entity;

@Entity
@Table(name = "custom_fields")
public class CustomField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     Many custom fields can belong to one event.
     Example:
     Event: Hackathon
     Custom Fields:
     - Project title
     - GitHub link
     - Team idea
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    /*
     Label shown to the user.
     Example:
     "Project Title"
     "GitHub Link"
     "Need Accommodation"
     */
    @Column(name = "field_name", nullable = false)
    private String fieldName;

    /*
     Internal key for frontend/backend processing.
     Example:
     fieldName = "Project Title"
     fieldKey = "project_title"
     */
    @Column(name = "field_key", nullable = false)
    private String fieldKey;

    /*
     Field type:
     TEXT, TEXTAREA, NUMBER, DROPDOWN, CHECKBOX, etc.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "field_type", nullable = false)
    private CustomFieldType fieldType;

    /*
     Whether the participant must fill this field.
     */
    @Column(name = "required")
    private Boolean required = false;

    /*
     For DROPDOWN, RADIO, CHECKBOX fields.
     For MVP, store options as comma-separated values.
     Example:
     "Beginner,Intermediate,Advanced"
     */
    @Column(name = "options", length = 2000)
    private String options;

    /*
     Placeholder shown inside input field.
     Example:
     "Enter your GitHub link"
     */
    @Column(name = "placeholder")
    private String placeholder;

    /*
     Extra instruction for user.
     Example:
     "Upload only public GitHub repository link"
     */
    @Column(name = "help_text", length = 1000)
    private String helpText;

    /*
     Validation for text fields.
     */
    @Column(name = "min_length")
    private Integer minLength;

    @Column(name = "max_length")
    private Integer maxLength;

    /*
     Validation for number fields.
     */
    @Column(name = "min_value")
    private Double minValue;

    @Column(name = "max_value")
    private Double maxValue;

    /*
     Controls order of fields on registration form.
     Example:
     1. Project Title
     2. GitHub Link
     3. Team Idea
     */
    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CustomField() {
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        if (this.required == null) {
            this.required = false;
        }

        if (this.active == null) {
            this.active = true;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public CustomFieldType getFieldType() {
        return fieldType;
    }

    public Boolean getRequired() {
        return required;
    }

    public String getOptions() {
        return options;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getHelpText() {
        return helpText;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public Boolean getActive() {
        return active;
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

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public void setFieldType(CustomFieldType fieldType) {
        this.fieldType = fieldType;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}