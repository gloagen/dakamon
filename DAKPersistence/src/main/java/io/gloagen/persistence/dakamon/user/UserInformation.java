/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.user;

import io.gloagen.persistence.dakamon.auth.Authentication;
import io.gloagen.persistence.dakamon.auth.Authorisation;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "USER_INFO")
public class UserInformation {
    @Id
    private long id;

    @OneToOne(optional = false)
    private Profile profile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Authentication authentication;

    public UserInformation() {
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

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
