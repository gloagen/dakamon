/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.org;

import io.gloagen.persistence.dakamon.auth.role.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Organisation {
    @Id
    private long id;

    @OneToOne(optional = false)
    private OrganisationInformation organisationInformation;

    @OneToMany(mappedBy = "organisation")
    private List<OrganisationAssoc> members;

    @OneToMany(mappedBy = "organisation")
    private List<Role> roles;

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

    public List<OrganisationAssoc> getMembers() {
        return members;
    }

    public void setMembers(List<OrganisationAssoc> members) {
        this.members = members;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
