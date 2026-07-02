package com.project.eventy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "super_admin_profiles")
public class SuperAdminProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     One super admin profile belongs to one user.
     User.role should be SUPER_ADMIN.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "admin_code", unique = true)
    private String adminCode;

    @Column(name = "designation")
    private String designation;

    /*
     Platform-level permissions.
     */
    @Column(name = "can_manage_organizations")
    private Boolean canManageOrganizations = true;

    @Column(name = "can_manage_all_users")
    private Boolean canManageAllUsers = true;

    @Column(name = "can_manage_all_events")
    private Boolean canManageAllEvents = true;

    @Column(name = "can_view_platform_reports")
    private Boolean canViewPlatformReports = true;

    @Column(name = "can_deactivate_organizations")
    private Boolean canDeactivateOrganizations = true;

    @Column(name = "can_deactivate_users")
    private Boolean canDeactivateUsers = true;

    @Column(name = "can_assign_org_admins")
    private Boolean canAssignOrgAdmins = true;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}