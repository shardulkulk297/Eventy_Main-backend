package com.project.eventy.entity;


import com.project.eventy.entity.enums.TicketStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     One ticket belongs to one registration.
     Usually, one registration should have one ticket.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_id", nullable = false, unique = true)
    private Registration registration;

    /*
     Human-readable unique ticket code.
     Example:
     EVT-2026-000123
     */
    @Column(name = "ticket_code", nullable = false, unique = true)
    private String ticketCode;

    /*
     Value used for QR code generation.
     For MVP, this can be same as ticketCode or a UUID.
     */
    @Column(name = "qr_code_value", nullable = false, unique = true)
    private String qrCodeValue;

    /*
     ACTIVE, CANCELLED, USED, EXPIRED
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status", nullable = false)
    private TicketStatus ticketStatus;

    @Column(name = "issued_at")
    private LocalDateTime issuedAt;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    /*
     True when participant has entered/checked in.
     */
    @Column(name = "checked_in")
    private Boolean checkedIn = false;

    @Column(name = "checked_in_at")
    private LocalDateTime checkedInAt;

    /*
     Event manager/admin who checked in the participant.
     Nullable until check-in happens.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checked_in_by_user_id")
    private User checkedInBy;

    /*
     Optional seat number for seat-based events.
     Example:
     A12, B05
     */
    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "remarks", length = 1000)
    private String remarks;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getQrCodeValue() {
        return qrCodeValue;
    }

    public void setQrCodeValue(String qrCodeValue) {
        this.qrCodeValue = qrCodeValue;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDateTime getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(LocalDateTime cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public LocalDateTime getCheckedInAt() {
        return checkedInAt;
    }

    public void setCheckedInAt(LocalDateTime checkedInAt) {
        this.checkedInAt = checkedInAt;
    }

    public User getCheckedInBy() {
        return checkedInBy;
    }

    public void setCheckedInBy(User checkedInBy) {
        this.checkedInBy = checkedInBy;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}