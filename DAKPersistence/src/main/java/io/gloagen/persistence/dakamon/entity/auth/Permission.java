/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.auth;

import io.gloagen.persistence.dakamon.entity.org.Organisation;
import io.gloagen.persistence.dakamon.entity.user.UserProfile;

import javax.persistence.*;
import java.util.List;

@Entity(name = "permz")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "ROLE_GEN")
    private long id;

    @OneToMany(mappedBy = "permission")
    private List<Authorisation> authorisations;

    @JoinTable(name = "upermz", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "profil_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<UserProfile> userProfiles;

    @ManyToMany(mappedBy = "permissions")
    private List<Organisation> organisations;

    public Permission() {
    }

}
