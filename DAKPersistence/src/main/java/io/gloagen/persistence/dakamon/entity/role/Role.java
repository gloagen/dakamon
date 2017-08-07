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
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "ROLE_GEN")
    private long id;

    @OneToMany(mappedBy = "role")
    private List<Authorisation> authorisations;

    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    })
    @ManyToMany
    private List<Profile> userProfiles;

    @ManyToMany(mappedBy = "roles")
    private List<Organisation> organisations;

    public Role() {
    }

}
