/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth.role;

import java.io.Serializable;

public class UserRoleId implements Serializable {
    private long userId;
    private long roleId;

    public UserRoleId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId)) return false;

        UserRoleId that = (UserRoleId) o;

        if (getUserId() != that.getUserId()) return false;
        return getRoleId() == that.getRoleId();
    }

    @Override
    public int hashCode() {
        int result = (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + (int) (getRoleId() ^ (getRoleId() >>> 32));
        return result;
    }
}
