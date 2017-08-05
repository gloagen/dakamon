/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.user;

import io.gloagen.persistence.dakamon.auth.role.Role;
import io.gloagen.persistence.dakamon.org.Organisation;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Preference> preferences;

    @ManyToMany(mappedBy = "members")
    private Collection<Organisation> organisations;

    @ManyToMany(mappedBy = "users")
    private Collection<Role> roles;


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

}
