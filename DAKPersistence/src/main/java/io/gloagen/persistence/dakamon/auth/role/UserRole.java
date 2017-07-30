/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth.role;

import io.gloagen.persistence.dakamon.user.User;

import javax.persistence.*;

@Entity
@IdClass(UserRoleId.class)
public class UserRole {

    @Id
    private long userId;

    @Id
    private long roleId;

    @ManyToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "ID")
    private Role role;

    public UserRole() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (getUserId() != userRole.getUserId()) return false;
        if (getRoleId() != userRole.getRoleId()) return false;
        if (!getUser().equals(userRole.getUser())) return false;
        return getRole().equals(userRole.getRole());
    }

    @Override
    public int hashCode() {
        int result = (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + (int) (getRoleId() ^ (getRoleId() >>> 32));
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }
}
