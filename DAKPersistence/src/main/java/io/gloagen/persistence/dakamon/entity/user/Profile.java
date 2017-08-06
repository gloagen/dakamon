/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import io.gloagen.persistence.dakamon.entity.org.Organisation;
import io.gloagen.persistence.dakamon.entity.role.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Profile {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_info")
    private UserInformation userInformation;

    @OneToMany(mappedBy = "user")
    private List<Preference> preferences;

    @ManyToMany(mappedBy = "userProfiles")
    private Collection<Organisation> organisations;

    @ManyToMany(mappedBy = "userProfiles")
    private List<Role> roles;

    public Profile() {
    }

}
