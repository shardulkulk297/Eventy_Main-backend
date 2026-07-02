package com.project.eventy.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "team_members")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     Team to which this member belongs.
     One team can have many team members.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    /*
     User who is part of the team.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /*
     True if this member is the team leader.
     Usually only one member in a team should have leader = true.
     */
    @Column(name = "leader")
    private Boolean leader = false;

    @Column(name = "joined_at")
    private LocalDateTime joinedAt;

    /*
     Useful if a member leaves or is removed.
     */
    @Column(name = "left_at")
    private LocalDateTime leftAt;

    @Column(name = "active")
    private Boolean active = true;
}