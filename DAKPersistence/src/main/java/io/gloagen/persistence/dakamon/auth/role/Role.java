/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth.role;

import io.gloagen.persistence.dakamon.auth.Authorisation;
import io.gloagen.persistence.dakamon.org.Organisation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Role {
    @Id
    private long id;

    @ManyToOne(optional = false)
    private Organisation organisation;

    @OneToMany(mappedBy = "role")
    private List<Authorisation> authorisations;

    @OneToMany(mappedBy = "role")
    private List<UserRole> users;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<Authorisation> getAuthorisations() {
        return authorisations;
    }

    public void setAuthorisations(List<Authorisation> authorisations) {
        this.authorisations = authorisations;
    }

    public List<UserRole> getUsers() {
        return users;
    }

    public void setUsers(List<UserRole> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (getId() != role.getId()) return false;
        if (!getOrganisation().equals(role.getOrganisation())) return false;
        if (!getAuthorisations().equals(role.getAuthorisations())) return false;
        return getUsers().equals(role.getUsers());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getOrganisation().hashCode();
        result = 31 * result + getAuthorisations().hashCode();
        result = 31 * result + getUsers().hashCode();
        return result;
    }
}
