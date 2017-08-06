/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.role;

import io.gloagen.persistence.dakamon.entity.auth.Authorisation;
import io.gloagen.persistence.dakamon.entity.org.Organisation;
import io.gloagen.persistence.dakamon.entity.user.Profile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    private long id;

    @OneToMany(mappedBy = "role")
    private List<Authorisation> authorisations;

    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "profile_id", referencedColumnName = "ID")
    })
    @ManyToMany
    private List<Profile> userProfiles;

    @ManyToMany(mappedBy = "roles")
    private List<Organisation> organisations;

    public Role() {
    }

}
