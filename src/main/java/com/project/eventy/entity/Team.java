package com.project.eventy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     The event this team belongs to.
     One event can have many teams.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    /*
     The logged-in user who created the team.
     This user is the team leader.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_user_id", nullable = false)
    private User leader;

    /*
     ACTIVE, CANCELLED, DISQUALIFIED, etc.
     */

    /*
     Optional description, project idea, or team objective.
     */
    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}