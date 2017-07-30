/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.user;

import io.gloagen.persistence.dakamon.auth.Authentication;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Profile {
    @Id
    private Long id;

    @OneToOne(mappedBy = "profile")
    private User user;

    @OneToOne(mappedBy = "profile")
    private UserInformation userInformation;

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
}
