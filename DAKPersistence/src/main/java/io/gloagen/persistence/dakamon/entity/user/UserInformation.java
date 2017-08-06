/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import io.gloagen.persistence.dakamon.entity.auth.Authentication;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USER_INFO")
public class UserInformation {
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "auth_id")
    private Authentication authentication;

    @OneToMany(mappedBy = "userInformation")
    private List<Profile> profiles;

    @OneToOne(optional = false)
    private User user;

    public UserInformation() {
    }

}
