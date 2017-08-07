/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.org;

import io.gloagen.persistence.dakamon.entity.role.Role;
import io.gloagen.persistence.dakamon.entity.user.Profile;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "ORG")
public class Organisation {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "ORG_GEN")
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "info_id")
    private OrganisationInformation organisationInformation;

    @JoinTable(name = "org_role", joinColumns = {
            @JoinColumn(name = "orgid", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "roleid", referencedColumnName = "ID")
    })
    @ManyToMany
    private Collection<Role> roles;

    @JoinTable(name = "user_org", joinColumns = {
            @JoinColumn(name = "org_id", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    })
    @ManyToMany
    private List<Profile> userProfiles;

    public Organisation() {
    }

}
