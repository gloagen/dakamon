/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.user;

import io.gloagen.persistence.dakamon.org.OrganisationAssoc;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    private long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Preference> preferences;


    @OneToMany(mappedBy = "user")
    private Collection<OrganisationAssoc> organisations;

    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Collection<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(Collection<Preference> preferences) {
        this.preferences = preferences;
    }

    public Collection<OrganisationAssoc> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(Collection<OrganisationAssoc> organisations) {
        this.organisations = organisations;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
