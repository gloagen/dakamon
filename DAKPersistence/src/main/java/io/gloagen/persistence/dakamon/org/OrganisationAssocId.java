/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.org;

import java.io.Serializable;

public class OrganisationAssocId implements Serializable {

    private long userId;
    private long organisationId;

    public OrganisationAssocId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganisationAssocId)) return false;

        OrganisationAssocId that = (OrganisationAssocId) o;

        if (userId != that.userId) return false;
        return organisationId == that.organisationId;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (organisationId ^ (organisationId >>> 32));
        return result;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }
}
