/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth;

import io.gloagen.persistence.dakamon.role.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Authorisation {
    @Id
    private long id;

    @ManyToOne
    private Role role;

    public Authorisation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        if (!(o instanceof Authorisation)) return false;

        Authorisation that = (Authorisation) o;

        if (getId() != that.getId()) return false;
        return getRole().equals(that.getRole());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getRole().hashCode();
        return result;
    }
}