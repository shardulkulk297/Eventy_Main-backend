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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getCanManageOrganizations() {
        return canManageOrganizations;
    }

    public void setCanManageOrganizations(Boolean canManageOrganizations) {
        this.canManageOrganizations = canManageOrganizations;
    }

    public Boolean getCanManageAllUsers() {
        return canManageAllUsers;
    }

    public void setCanManageAllUsers(Boolean canManageAllUsers) {
        this.canManageAllUsers = canManageAllUsers;
    }

    public Boolean getCanManageAllEvents() {
        return canManageAllEvents;
    }

    public void setCanManageAllEvents(Boolean canManageAllEvents) {
        this.canManageAllEvents = canManageAllEvents;
    }

    public Boolean getCanViewPlatformReports() {
        return canViewPlatformReports;
    }

    public void setCanViewPlatformReports(Boolean canViewPlatformReports) {
        this.canViewPlatformReports = canViewPlatformReports;
    }

    public Boolean getCanDeactivateOrganizations() {
        return canDeactivateOrganizations;
    }

    public void setCanDeactivateOrganizations(Boolean canDeactivateOrganizations) {
        this.canDeactivateOrganizations = canDeactivateOrganizations;
    }

    public Boolean getCanDeactivateUsers() {
        return canDeactivateUsers;
    }

    public void setCanDeactivateUsers(Boolean canDeactivateUsers) {
        this.canDeactivateUsers = canDeactivateUsers;
    }

    public Boolean getCanAssignOrgAdmins() {
        return canAssignOrgAdmins;
    }

    public void setCanAssignOrgAdmins(Boolean canAssignOrgAdmins) {
        this.canAssignOrgAdmins = canAssignOrgAdmins;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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