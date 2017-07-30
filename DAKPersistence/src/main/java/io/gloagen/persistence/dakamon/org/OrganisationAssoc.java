/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.org;

import io.gloagen.persistence.dakamon.user.User;

import javax.persistence.*;

@Entity
@Table(name = "USER_ORG")
@IdClass(OrganisationAssocId.class)
public class OrganisationAssoc {

    @Id
    private long userId;

    @Id
    private long orgId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "USERID", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ORGID", referencedColumnName = "ID")
    private Organisation organisation;

    public OrganisationAssoc() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
