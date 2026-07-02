package com.project.eventy.entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     The event for which the user is registering.
     Many registrations can belong to one event.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    /*
     The user who registered for the event.
     Can be participant, student, professional, etc.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /*
     If the event is team-based, this registration belongs to a team.
     For individual events, this will be null.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    /*
     Registration status:
     REGISTERED, CANCELLED, WAITLISTED, APPROVED, REJECTED, ATTENDED
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    /*
     Useful if some events require manager approval.
     */
    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    /*
     User who approved the registration.
     Usually event manager or org admin.
     Nullable because approval may not be required.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by_user_id")
    private User approvedBy;

    @Column(name = "remarks", length = 1000)
    private String remarks;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
