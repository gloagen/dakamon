/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.org;

import io.gloagen.persistence.dakamon.auth.role.Role;
import io.gloagen.persistence.dakamon.user.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity(name = "ORG")
public class Organisation {
    @Id
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "info_id")
    private OrganisationInformation organisationInformation;

    @JoinTable(name = "org_role", joinColumns = {
            @JoinColumn(name = "orgid", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "roleid", referencedColumnName = "ID")
    })
    @ManyToMany
    private Collection<Role> roles;

    @JoinTable(name = "user_org", joinColumns = {
            @JoinColumn(name = "orgid", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "userid", referencedColumnName = "ID")
    })
    @ManyToMany
    private Set<User> members;

    public Organisation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrganisationInformation getOrganisationInformation() {
        return organisationInformation;
    }

    public void setOrganisationInformation(OrganisationInformation organisationInformation) {
        this.organisationInformation = organisationInformation;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
